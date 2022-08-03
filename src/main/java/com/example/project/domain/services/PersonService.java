package com.example.project.domain.services;

import com.example.project.domain.entities.Person;
import com.example.project.domain.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person salve(Person obj) {
        return personRepository.save(obj);
    }

    public Person findById(Long id) {
        Optional<Person> obj = personRepository.findById(id);
        return obj.get();
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public Person update(Long id, Person obj) {
        Person entity = personRepository.getReferenceById(id);
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setBirthDate(obj.getBirthDate());
        return entity;
    }
}
