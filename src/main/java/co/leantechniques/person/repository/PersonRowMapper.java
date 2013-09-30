package co.leantechniques.person.repository;

import co.leantechniques.person.domain.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person result = new Person();
        result.setId(resultSet.getLong("id"));
        result.setFirstName(resultSet.getString("firstname"));
        result.setFirstName(resultSet.getString("lastname"));
        return result;
    }

}
