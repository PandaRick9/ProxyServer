package by.baraznov.proxyserver.controllers;

import by.baraznov.proxyserver.service.AdminsService;
import by.baraznov.proxyserver.util.PersonErrorResponse;
import by.baraznov.proxyserver.util.PersonNotCreatedException;
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
    @Autowired
    public AdminController(AdminsService adminsService) {
        this.adminsService = adminsService;
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
            //throw new PersonNotCreatedException(errorMessage.toString());
        }
        //save person on DB
        //TODO
        adminsService.setAllFieldsForAdmin(jsonRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /*@ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotCreatedException e){
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }*/
}
