package com.example.project.config;

import com.example.project.domain.entities.*;
import com.example.project.domain.entities.enums.AddressType;
import com.example.project.domain.entities.enums.Function;
import com.example.project.domain.entities.enums.Sex;
import com.example.project.domain.entities.enums.StudentStatus;
import com.example.project.domain.repositories.CourseRepository;
import com.example.project.domain.repositories.PersonRepository;
import com.example.project.domain.repositories.UnityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UnityRepository unityRepository;

    @Override
    public void run(String... args) throws Exception {
        //Address of Person
        Address a1 = new Address("Tv. 13 de Junho", 206, "Pratinha-Icoaraci", "Belém", "Pará", AddressType.RESIDENTIAL);

        //Address of Unity
        Address au1 = new Address("Av. Alcindo Cancela", 1320, "Umarizal", "Belém", "Pará", AddressType.COMMERCIAL);

        Person p1 = new Student("Marcos", LocalDate.parse("1997-09-08"), "marcos.alexandria01@gmail.com", "Brasil", Function.STUDENT, Sex.M, a1, StudentStatus.APPROVED);

        Unity u1 = new Unity("Umarizal", au1);
        unityRepository.save(u1);

        Course c1 = new Course("Analise de Sistemas", 1200.0, 2.0, 135.95);

        c1.getUnityList().add(u1);

        courseRepository.save(c1);


        p1.getCourseList().add(c1);


        personRepository.save(p1);




       // Matter m1 = new Matter("Banco de Dados", 6.7, 8.0);






    }
}
