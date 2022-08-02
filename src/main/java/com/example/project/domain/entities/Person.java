package com.example.project.domain.entities;

import com.example.project.domain.entities.enums.Function;
import com.example.project.domain.entities.enums.Sex;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Person extends AbstractPersistable<Long> {
    private String name;
    private LocalDate birthDate;
    private String email;
    private String nationality;
    @Enumerated(EnumType.STRING)
    private Function function;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Person() {
    }

    public Person(String name, LocalDate birthDate, String email, String nationality, Function function, Sex sex, Address address) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.nationality = nationality;
        this.function = function;
        this.sex = sex;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
