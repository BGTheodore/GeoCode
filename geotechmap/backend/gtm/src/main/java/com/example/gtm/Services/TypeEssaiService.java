package com.example.gtm.Services;

import java.util.List;
import java.util.Optional;

import com.example.gtm.Entities.TypeEssai;
import com.example.gtm.Exception.ResourceNotFoundException;
import com.example.gtm.Repositories.TypeEssaiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeEssaiService {
    @Autowired
    TypeEssaiRepository repository;

    public TypeEssai createNewTypeEssai(TypeEssai typeEssai) {
        return repository.save(typeEssai);
        }

    public List<TypeEssai> listAllTypeEssais() {
        return repository.findAll();
        }
    
    public TypeEssai updateTypeEssai(Long id, TypeEssai typeEssai) {
        Optional<TypeEssai> optional = repository.findById(id);
        if (!optional.isPresent()) {
        throw new ResourceNotFoundException("Type Essai not found with id :" + id);
        } else {
            typeEssai.setId(id);
            return repository.save(typeEssai);
        }
    }

    public void deleteTypeEssai(Long id) {
        Optional<TypeEssai> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Type Essai not found with id :" + id);
        } else {
            repository.deleteById(id);
        }
    }

    public Optional<TypeEssai> getTypeEssai(Long id) {
        Optional<TypeEssai> optional = repository.findById(id);
        if (!optional.isPresent()) {
        throw new ResourceNotFoundException("Type Essai not found with id :" + id);
        } else {
        return optional;
        }
    }
}
