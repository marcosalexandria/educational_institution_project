package com.example.project.domain.services;

import com.example.project.domain.entities.Unity;
import com.example.project.domain.repositories.UnityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnityService {
    @Autowired
    private UnityRepository unityRepository;

    public Unity save(Unity obj) {
        return unityRepository.save(obj);
    }

    public Unity findById(Long id) {
        Optional<Unity> obj = unityRepository.findById(id);
        return obj.get();
    }

    public void deleteById(Long id) {
        unityRepository.deleteById(id);
    }

    public Unity update(Long id, Unity obj) {
        Unity entity = unityRepository.getReferenceById(id);
        entity.setName(obj.getName());
        entity.setAddress(obj.getAddress());
        return entity;
    }
}
