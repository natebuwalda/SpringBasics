package co.leantechniques.person.service;

import co.leantechniques.person.domain.Person;
import co.leantechniques.person.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BasePersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private BasePersonService personService;

    @Test
    public void testCalculateFullName() throws Exception {
        Person person = new Person();
        person.setFirstName("Nate");
        person.setLastName("Buwalda");
        Mockito.when(personRepository.find(1L)).thenReturn(person);

        String result = personService.calculateFullName(1L);

        assertEquals("Nate Buwalda", result);
    }
}
