package com.example.gtm.Services;

import java.util.List;
import java.util.Optional;

import com.example.gtm.Entities.Institution;
import com.example.gtm.Exception.ResourceNotFoundException;
import com.example.gtm.Repositories.InstitutionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {
    @Autowired
    InstitutionRepository repository;

    public Institution createNewInstitution(Institution institution) {
        return repository.save(institution);
    }

    public List<Institution> listAllInstitutions(){
        return repository.findAll();
    }

    public Institution updateInstitution(Long id, Institution institution){
        Optional<Institution> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new ResourceNotFoundException("Institution not found with id :" + id );
        } else {
            institution.setId(id);
            return repository.save(institution);
        }
    }

    public void deleteInstitution(Long id) {
        Optional<Institution> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new ResourceNotFoundException("Institution not found with id :" + id );
        } else {
            repository.deleteById(id);
        }
    }

    public Institution getInstitution(Long id) {
        Optional<Institution> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new ResourceNotFoundException("Institution not found with id :" + id );
        } else {
            return optional.get();
        }
    }
}
