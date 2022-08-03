package com.example.project.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class Course extends AbstractPersistable<Long> {
    private String name;
    private Double loadInHours;
    private Double durationYears;
    private Double monthlyPrice;
    @JsonIgnore
    @ManyToMany(mappedBy = "courseList")
    private List<Person> personList = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "tb_course_unity", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "unity_id"))
    private List<Unity> unityList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_course_matter", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "matter_id"))
    private List<Matter> matters = new ArrayList<>();

    public Course() {
    }

    public Course(String name, Double loadinHours, Double durationYears, Double monthlyPrice) {
        this.name = name;
        this.loadInHours = loadinHours;
        this.durationYears = durationYears;
        this.monthlyPrice = monthlyPrice;
    }

    private Double getTotalInvestment() {
        Double sum = monthlyPrice * 12 * durationYears;
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLoadInHours() {
        return loadInHours;
    }

    public void setLoadInHours(Double loadInHours) {
        this.loadInHours = loadInHours;
    }

    public Double getDurationYears() {
        return durationYears;
    }

    public void setDurationYears(Double durationYears) {
        this.durationYears = durationYears;
    }

    public Double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(Double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Unity> getUnityList() {
        return unityList;
    }

    public void setUnityList(List<Unity> unityList) {
        this.unityList = unityList;
    }

    public List<Matter> getMatters() {
        return matters;
    }

    public void setMatters(List<Matter> matters) {
        this.matters = matters;
    }
}