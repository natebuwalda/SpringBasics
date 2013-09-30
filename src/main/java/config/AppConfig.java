package config;

import co.leantechniques.person.domain.Person;
import co.leantechniques.person.repository.PersonJdbcTemplateRepository;
import co.leantechniques.person.repository.PersonRepository;
import co.leantechniques.person.repository.PersonRowMapper;
import co.leantechniques.person.service.BasePersonService;
import co.leantechniques.person.service.PersonService;
import co.leantechniques.pet.service.BasePetService;
import co.leantechniques.pet.service.PetService;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class AppConfig {

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public RowMapper<Person> personRowMapper() {
        return new PersonRowMapper();
    }

    @Bean
    public JdbcOperations jdbcOperations() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PersonRepository personRepository() {
        return new PersonJdbcTemplateRepository(jdbcOperations(), personRowMapper());
    }

    @Bean
    public PersonService personService() {
        return new BasePersonService((PersonJdbcTemplateRepository) personRepository());
    }

    @Bean
    public PetService petService() {
        return new BasePetService();
    }
}
