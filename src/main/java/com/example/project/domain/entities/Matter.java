package com.example.project.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Matter extends AbstractPersistable<Long> {
    private String name;
    private Double test1;
    private Double test2;
    @JsonIgnore
    @ManyToMany(mappedBy = "matters")
    private List<Course> courses = new ArrayList<>();

    public Matter() {
    }

    public Matter(String name, Double test1, Double test2) {
        this.name = name;
        this.test1 = test1;
        this.test2 = test2;
    }

    public Double getCalculateAverage() {
        Double average = (test1 + test2) / 2;
        return average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTest1() {
        return test1;
    }

    public void setTest1(Double test1) {
        this.test1 = test1;
    }

    public Double getTest2() {
        return test2;
    }

    public void setTest2(Double test2) {
        this.test2 = test2;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
