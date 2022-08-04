package com.example.project.domain.entities;

import com.example.project.domain.entities.enums.Function;
import com.example.project.domain.entities.enums.Sex;

import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
public class Teacher extends Person{
    private Double remuneration;
    private LocalDate admissionDate;

    public Teacher() {
    }

    public Teacher(String name, LocalDate birthDate, String email, String nationality, Function function, Sex sex, Address address, Double remuneration, LocalDate admissionDate) {
        super(name, birthDate, email, nationality, function, sex, address);
        this.remuneration = remuneration;
        this.admissionDate = admissionDate;
    }

    public Double getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(Double remuneration) {
        this.remuneration = remuneration;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
}
