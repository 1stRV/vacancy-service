package ru.roman.firstov.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class VacancyServiceApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(VacancyServiceApplication.class, args);
    }
    //для теста
    @PostConstruct
    public void fillDataBase() {
        jdbcTemplate.update("CREATE TABLE vacancy (\n" +
                "  id         INTEGER AUTO_INCREMENT,\n" +
                "  name       VARCHAR(255),\n" +
                "  salary     INTEGER,\n" +
                "  experience VARCHAR(255),\n" +
                "  city       VARCHAR(255)\n" +
                ")");
    }
}
