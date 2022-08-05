package com.example.project.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Unity extends AbstractPersistable<Long> {
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToMany
    @JoinTable(name = "tb_unity_course"
            , joinColumns = @JoinColumn(name = "unity_id")
            , inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courseList = new ArrayList<>();

    public Unity() {
    }

    public Unity(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
