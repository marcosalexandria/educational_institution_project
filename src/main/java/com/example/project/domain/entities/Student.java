package com.example.project.domain.entities;

import com.example.project.domain.entities.enums.Function;
import com.example.project.domain.entities.enums.Sex;
import com.example.project.domain.entities.enums.StudentStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
@Entity
public class Student extends Person{
    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    public Student() {
    }

    public Student(String name, LocalDate birthDate, String email, String nationality, Function function, Sex sex, Address address, StudentStatus status) {
        super(name, birthDate, email, nationality, function, sex, address);
        this.status = status;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }
}
