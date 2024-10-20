package by.baraznov.proxyserver.service;

import by.baraznov.proxyserver.models.Person;
import by.baraznov.proxyserver.repositories.PeopleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository personRepository) {
        this.peopleRepository = personRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id,Person person) {
        person.setUserId(id);
        peopleRepository.save(person);
    }
    @Transactional
    public void delete(Person person){
        peopleRepository.delete(person);
    }

    public void setAllFieldsForPerson(String jsonRequest) throws JsonProcessingException {
        Person person = new Person();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonRequest);
        String email = jsonNode.get("Email").asText();
        String endpoint = jsonNode.get("Endpoint").asText();
        String login = jsonNode.get("Login").asText();
        String message = jsonNode.get("Message").asText();
        String supportLevel = jsonNode.get("SupportLevel").asText();
        long timestamp = jsonNode.get("Timestamp").asLong();
        long userId = jsonNode.get("UserID").asLong();
        person.setUserId(userId);
        person.setEmail(email);
        person.setEndpoint(endpoint);
        person.setLogin(login);
        person.setMessage(message);
        person.setSupportLevel(supportLevel);
        person.setTimestamp(timestamp);
        System.out.println(person);
    }
}