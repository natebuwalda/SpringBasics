package co.leantechniques.person.repository;

import co.leantechniques.person.domain.Person;

public interface PersonRepository {

    Person find(long id);

}
