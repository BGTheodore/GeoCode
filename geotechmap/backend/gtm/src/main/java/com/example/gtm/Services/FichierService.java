package com.example.gtm.Services;

import java.util.List;
import java.util.Optional;

import com.example.gtm.Entities.Fichier;
import com.example.gtm.Exception.ResourceNotFoundException;
import com.example.gtm.Repositories.FichierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FichierService {
    @Autowired
    FichierRepository repository;

    public Fichier createNewFichier(Fichier fichier) {
        return repository.save(fichier);
        }

    public List<Fichier> listAllFichiers() {
        return repository.findAll();
        }
    
    public Fichier updateFichier(Long id, Fichier fichier) {
        Optional<Fichier> optional = repository.findById(id);
        if (!optional.isPresent()) {
        throw new ResourceNotFoundException("Fichier not found with id :" + id);
        } else {
            fichier.setId(id);
            return repository.save(fichier);
        }
    }

    public void deleteFichier(Long id) {
        Optional<Fichier> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Fichier not found with id :" + id);
        } else {
            repository.deleteById(id);
        }
    }

    public Optional<Fichier> getFichier(Long id) {
        Optional<Fichier> optional = repository.findById(id);
        if (!optional.isPresent()) {
        throw new ResourceNotFoundException("Fichier not found with id :" + id);
        } else {
        return optional;
        }
    }
}
