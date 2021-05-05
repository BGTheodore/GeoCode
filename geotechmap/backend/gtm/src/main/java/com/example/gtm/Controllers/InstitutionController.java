package com.example.gtm.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.gtm.Entities.Institution;
import com.example.gtm.Repositories.InstitutionRepository;
import com.example.gtm.Services.InstitutionService;

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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/institutions")
public class InstitutionController {
    @Autowired
    InstitutionService service;
    InstitutionRepository repository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Institution> createNewInstitution(@Valid @RequestBody Institution institution){
        Institution createdInstitution = service.createNewInstitution(institution);
        return new ResponseEntity<>(createdInstitution, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Institution>> getAllInstitutions(){
        return ResponseEntity.ok().body(service.listAllInstitutions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Institution>> getInstitution(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getInstitution(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Institution> updateInstitution(@RequestBody Institution institution, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.updateInstitution(id, institution));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstitution(@PathVariable Long id){
        service.deleteInstitution(id);
    }
}
