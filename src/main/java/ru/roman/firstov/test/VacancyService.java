package ru.roman.firstov.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by RVFirstov.ru
 */
@Service
public class VacancyService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VacancyModel> getAllVacancies() {
        return jdbcTemplate.query("SELECT * FROM vacancy", new VacancyMapper());
    }

    public VacancyModel createVacancy(VacancyModel vacancyModel) {
        jdbcTemplate.update("INSERT INTO vacancy(name, salary, experience, city) " +
                        "VALUES (?, ?, ?, ?)",
                vacancyModel.getName(),
                vacancyModel.getSalary(),
                vacancyModel.getExperience(),
                vacancyModel.getCity());
        return vacancyModel;
    }

    public VacancyModel getVacancyById(int id) {
        List<VacancyModel> result = jdbcTemplate.query("SELECT * FROM vacancy WHERE id = ?", new VacancyMapper(), id);
        return result.get(0);
    }

    public void removeVacancy(int id) {
        jdbcTemplate.update("DELETE FROM vacancy WHERE id = ?", id);
    }

    private class VacancyMapper implements RowMapper<VacancyModel> {
        @Nullable
        @Override
        public VacancyModel mapRow(ResultSet resultSet, int i) throws SQLException {
            return new VacancyModel(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("salary"),
                    resultSet.getString("experience"),
                    resultSet.getString("city"));
        }
    }
}
