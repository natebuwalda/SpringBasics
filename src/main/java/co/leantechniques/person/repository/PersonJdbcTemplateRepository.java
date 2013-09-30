package co.leantechniques.person.repository;

import co.leantechniques.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcTemplateRepository implements PersonRepository {

    private JdbcOperations jdbcTemplate;
    private final RowMapper<Person> personMapper;

    @Autowired
    public PersonJdbcTemplateRepository(JdbcOperations jdbcTemplate, RowMapper<Person> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.personMapper = rowMapper;
    }

    @Override
    public Person find(long id) {
        return jdbcTemplate.queryForObject("select * from person where id = ?", personMapper, id);
    }

}
