package by.baraznov.proxyserver.service;

import by.baraznov.proxyserver.models.Admin;
import by.baraznov.proxyserver.models.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminsService {
    public void setAllFieldsForAdmin(String jsonRequest) throws JsonProcessingException {
        Admin admin = new Admin();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonRequest);
        String name = jsonNode.get("name").asText();
        String filter = jsonNode.get("filter").asText();
        String masking = jsonNode.get("masking").asText();
        admin.setName(name);
        admin.setFilter(filter);
        admin.setMasking(masking);
        System.out.println(admin);

    }
}
