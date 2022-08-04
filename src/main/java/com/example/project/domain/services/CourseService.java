package com.example.project.domain.services;

import com.example.project.domain.entities.Course;
import com.example.project.domain.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course findById(Long id) {
        Optional<Course> obj = courseRepository.findById(id);
        return obj.get();
    }

    public Course salve(Course obj) {
        return courseRepository.save(obj);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public Course update(Long id, Course obj) {
        Course entity = courseRepository.getReferenceById(id);
        entity.setName(obj.getName());
        entity.setDurationYears(obj.getDurationYears());
        entity.setMonthlyPrice(obj.getMonthlyPrice());
        return entity;
    }
}
