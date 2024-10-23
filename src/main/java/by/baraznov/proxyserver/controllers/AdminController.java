package by.baraznov.proxyserver.controllers;

import by.baraznov.proxyserver.models.Person;
import by.baraznov.proxyserver.service.AdminsService;
import by.baraznov.proxyserver.service.PeopleService;
import by.baraznov.proxyserver.util.AdminErrorResponse;
import by.baraznov.proxyserver.util.AdminJsonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminsService adminsService;
    private final PeopleService peopleService;

    @Autowired
    public AdminController(AdminsService adminsService, PeopleService peopleService) {
        this.adminsService = adminsService;
        this.peopleService = peopleService;
    }


    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody String jsonRequest,
                                             BindingResult bindingResult) throws JsonProcessingException {
        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error: errors){
                errorMessage.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new AdminJsonException(errorMessage.toString());
        }
        adminsService.setAllFieldsForAdmin(jsonRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @ExceptionHandler
    private ResponseEntity<AdminErrorResponse> handleException(AdminJsonException e){
        AdminErrorResponse response = new AdminErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
