package com.example.gtm.Services;


import java.util.List;
import java.util.Optional;

import com.example.gtm.Entities.Essai;
import com.example.gtm.Exception.ResourceNotFoundException;
import com.example.gtm.Repositories.EssaiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class EssaiService {
    @Autowired
    EssaiRepository repository;

    public Essai createNewEssai(Essai essai) {
        return repository.save(essai);
        }

    public List<Essai> listAllEssais() {
        return repository.findAll();
        }

    public Essai updateEssai(Long id, Essai essai) {
        Optional<Essai> optional = repository.findById(id);
        if (!optional.isPresent()) {
        throw new ResourceNotFoundException("Essai not found with id :" + id);
        } else {
            essai.setId(id);
            return repository.save(essai);
        }
    }

    public void deleteEssai(Long id) {
        Optional<Essai> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Essai not found with id :" + id);
        } else {
            repository.deleteById(id);
        }
    }

    public Essai getEssai(Long id) {
        Optional<Essai> optional = repository.findById(id);
        if (!optional.isPresent()) {
        throw new ResourceNotFoundException("Essai not found with id :" + id);
        } else {
        return optional.get();
        }
    }

    public List<Essai> rechercheParmotsCles(String mot_cle) {
        return repository.rechercheParmotsCles(mot_cle);
    }

}
