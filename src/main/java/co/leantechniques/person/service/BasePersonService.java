package co.leantechniques.person.service;

import co.leantechniques.person.domain.Person;
import co.leantechniques.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasePersonService implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public BasePersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public String calculateFullName(Long id) {
        Person found = personRepository.find(id);
        return found.getFirstName() + " " + found.getLastName();
    }

}
