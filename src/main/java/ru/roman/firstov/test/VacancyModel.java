package ru.roman.firstov.test;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by RVFirstov.ru
 */
@XmlRootElement
public class VacancyModel {
    private int id;
    private String name;
    private int salary;
    private String experience;
    private String city;

    public VacancyModel() {
    }

    public VacancyModel(int id, String name, int salary, String experience, String city) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.experience = experience;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "VacancyModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", experience='" + experience + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
