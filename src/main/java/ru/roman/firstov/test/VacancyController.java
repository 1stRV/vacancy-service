package ru.roman.firstov.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by RVFirstov.ru
 */
@RestController("/api")
public class VacancyController {
    private Logger log = LoggerFactory.getLogger(VacancyController.class);

    @Autowired
    private VacancyService vacancyService;

    @GetMapping("/vacancy")
    public List<VacancyModel> listAllVacancy() {
        log.info("GET ALL");
        return vacancyService.getAllVacancies();
    }

    @PutMapping("/vacancy")
    public VacancyModel createVacancy(@RequestBody VacancyModel vacancyModel) {
        log.info("CREATE {}", vacancyModel);
        vacancyService.createVacancy(vacancyModel);
        return vacancyModel;
    }

    @GetMapping("/vacancy/{id}")
    public VacancyModel getVacancyById(@PathVariable("id") int id) {
        log.info("GET By ID {}", id);
        return vacancyService.getVacancyById(id);
    }

    @DeleteMapping("vacancy/{id}")
    public void removeVacancy(@PathVariable("id") int id) {
        log.info("REMOVE BY ID {}", id);
        vacancyService.removeVacancy(id);
    }
}
