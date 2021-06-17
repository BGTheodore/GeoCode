package com.example.gtm.Controllers;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.gtm.Entities.Institution;
import com.example.gtm.Repositories.InstitutionRepository;
import com.example.gtm.Services.InstitutionService;

import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Dto.Institution.InstitutionDto;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/institutions")
public class InstitutionController {
    @Autowired
    InstitutionService service;
    InstitutionRepository repository;

    final ModelMapper modelMapper = new ModelMapper();

    
    private InstitutionDto convertToDto(Institution institution) {
        InstitutionDto institutionDto = modelMapper.map(institution, InstitutionDto.class);
        // InstitutionDto.setSubmissionDate(Institution.getSubmissionDate(), 
        //     userService.getCurrentUser().getPreference().getTimezone());
        return institutionDto;
    }

    private Institution convertToEntity(InstitutionDto institutionDto) throws ParseException {
        Institution institution = modelMapper.map(institutionDto, Institution.class);
        return institution;
    }
    

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public InstitutionDto createNewInstitution(@Valid @RequestBody InstitutionDto institutionDto) throws ParseException{
        Institution institution = convertToEntity(institutionDto);
        Institution intitutionCreated = service.createNewInstitution(institution);
        return convertToDto(intitutionCreated);
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<InstitutionDto>> getAllInstitutions(){
        return ResponseEntity.ok().body(service.listAllInstitutions());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public InstitutionDto getInstitution(@PathVariable Long id){
        return convertToDto(service.getInstitution(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Institution> updateInstitution(@RequestBody InstitutionDto institutionDto, @PathVariable Long id) throws ParseException {
        Institution institution = convertToEntity(institutionDto);
        return ResponseEntity.ok().body(service.updateInstitution(id, institution));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstitution(@PathVariable Long id){
        service.deleteInstitution(id);
    }
}
