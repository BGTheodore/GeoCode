package com.example.geotech.Services;

import java.util.List;
import java.util.Optional;

import com.example.geotech.Entities.Institution;
import com.example.geotech.Exception.ResourceNotFoundException;
import com.example.geotech.Repositories.InstitutionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {
    @Autowired
    InstitutionRepository repository;

    public Institution createNewInstitution(Institution institution) {
        return repository.save(institution);
        }
    
    public List<Institution> listAllInstitutions() {
        return repository.findAll();
        }

    public Institution updateInstitution(Long id, Institution institution) {
        Optional<Institution> institutionOptional = repository.findById(id);
        if (!institutionOptional.isPresent()) {
        throw new ResourceNotFoundException("Institution not found with id :" + id);
        } else {
            institution.setId(id);
           return repository.save(institution);
        }
    }

    public void deleteInstitution(Long id) {
        Optional<Institution> institutionOptional = repository.findById(id);
        if (!institutionOptional.isPresent()) {
            throw new ResourceNotFoundException("Institution not found with id :" + id);
        } else {
            repository.deleteById(id);
        }
    }

    public Optional<Institution> getInstitution(Long id) {
        Optional<Institution> institutionOptional = repository.findById(id);
        if (!institutionOptional.isPresent()) {
        throw new ResourceNotFoundException("Institution not found with id :" + id);
        } else {
        return institutionOptional;
        }
    }
}
