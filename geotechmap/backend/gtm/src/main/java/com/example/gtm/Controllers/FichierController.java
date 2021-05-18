package com.example.gtm.Controllers;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.gtm.Entities.Fichier;
import com.example.gtm.Repositories.FichierRepository;
import com.example.gtm.Services.FichierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/fichiers")
@CrossOrigin(origins = "http://localhost:3000")
public class FichierController {
    @Autowired
    FichierService service;
    FichierRepository repository;

    //Create a File
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fichier> createNewFichier(@Valid @RequestBody Fichier fichier) {         
        Fichier createdFichier = service.createNewFichier(fichier);
            return new ResponseEntity<>(createdFichier, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<List<Fichier>>  getAllFichiers(){
        return ResponseEntity.ok().body(service.listAllFichiers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Fichier>> getFichier(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getFichier(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Fichier> updateFichier(@RequestBody Fichier fichier, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.updateFichier(id, fichier));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteFichier(@PathVariable Long id) {
            service.deleteFichier(id);
    }
    
}