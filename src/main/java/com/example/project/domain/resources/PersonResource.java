package com.example.project.domain.resources;

import com.example.project.domain.entities.Person;
import com.example.project.domain.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("people")
public class PersonResource {
    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(personService.findById(id));
    }
}
