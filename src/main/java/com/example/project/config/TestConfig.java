package com.example.project.config;

import com.example.project.domain.entities.*;
import com.example.project.domain.entities.enums.AddressType;
import com.example.project.domain.entities.enums.Function;
import com.example.project.domain.entities.enums.Sex;
import com.example.project.domain.entities.enums.StudentStatus;
import com.example.project.domain.repositories.CourseRepository;
import com.example.project.domain.repositories.MatterRepository;
import com.example.project.domain.repositories.PersonRepository;
import com.example.project.domain.repositories.UnityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UnityRepository unityRepository;

    @Autowired
    private MatterRepository matterRepository;

    @Override
    public void run(String... args) throws Exception {
        //Address of Person
        Address a1 = new Address("Tv. 13 de Junho", 206, "Pratinha-Icoaraci", "Belém", "Pará", AddressType.RESIDENTIAL);
        Address a2 = new Address("Rua. Imperador", 3, "Pratinha-Icoaraci", "Belém", "Pará", AddressType.COMMERCIAL);
        Address a3 = new Address("Av. Pedro Mirando", 645, "Pedreira", "Belém", "Pará", AddressType.RESIDENTIAL);
        Address a4 = new Address("Av. Arthur Bernades", 35, "Telégrafo", "Belém", "Pará", AddressType.RESIDENTIAL);
        Address a5 = new Address("Rua dos Mundurucus", 76, "Jurunas", "Belém", "Pará", AddressType.COMMERCIAL);

        //Address of Unity
        Address au1 = new Address("Av. Alcindo Cancela", 1320, "Umarizal", "Belém", "Pará", AddressType.COMMERCIAL);
        Address au2 = new Address("Av. Generalissimo", 753, "Nazaré", "Belém", "Pará", AddressType.COMMERCIAL);

        Person p1 = new Student("Marcos Alexandria", LocalDate.parse("1997-09-08"), "marcos.alexandria01@gmail.com", "Brasil", Function.STUDENT, Sex.M, a1, StudentStatus.APPROVED);
        Person p2 = new Student("João Alberto", LocalDate.parse("1992-01-22"), "joão@gmail.com", "Brasil", Function.STUDENT, Sex.M, a2, StudentStatus.DISAPPROVED);
        Person p3 = new Student("Maria Helena", LocalDate.parse("1999-12-07"), "maria@gmail.com", "Brasil", Function.STUDENT, Sex.F, a3, StudentStatus.RECOVERY);

        Person p4 = new Teacher("Amélia Rodrigues", LocalDate.parse("1976-08-21"), "ameliarodrigues@gmail.com", "Brasil", Function.TEACHER, Sex.F, a4, 2400.0, LocalDate.parse("2011-02-01"));
        Person p5 = new Teacher("Caio Henrrique", LocalDate.parse("1981-02-06"), "caiohenrrique@gmail.com", "Brasil", Function.TEACHER, Sex.M, a5, 2157.0, LocalDate.parse("2015-11-08"));

        Unity u1 = new Unity("Umarizal", au1);
        Unity u2 = new Unity("Centro", au2);


        Course c1 = new Course("Analise de Sistemas", 1200.0, 2.0, 135.95);
        Course c2 = new Course("Engenharia de Software", 2400.0, 4.0, 390.00);
        Course c3 = new Course("Administração", 4400.0, 4.0, 255.95);

        Matter m1 = new Matter("Banco de Dados", 6.7, 8.0);

        matterRepository.save(m1);

        c1.getMatters().add(m1);
        c2.getMatters().add(m1);

        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);

        u1.getCourseList().add(c1);
        u1.getCourseList().add(c2);
        u2.getCourseList().add(c1);
        u2.getCourseList().add(c3);

        unityRepository.save(u1);
        unityRepository.save(u2);

        p1.getCourseList().add(c1);
        p2.getCourseList().add(c2);
        p3.getCourseList().add(c3);
        p4.getCourseList().add(c1);
        p4.getCourseList().add(c2);
        p5.getCourseList().add(c3);

        p1.getPreferentialUnity().add(u1);
        p2.getPreferentialUnity().add(u1);
        p3.getPreferentialUnity().add(u2);

        personRepository.save(p1);
        personRepository.save(p2);
        personRepository.save(p3);
        personRepository.save(p4);
        personRepository.save(p5);

    }
}
