package com.example.gtm.Services;

import java.util.List;
import java.util.Optional;

import com.example.gtm.Entities.Institution;
import com.example.gtm.Exception.ResourceNotFoundException;
import com.example.gtm.Repositories.InstitutionRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;
import Dto.Institution.InstitutionDto;

@Service
public class InstitutionService {
    @Autowired
    InstitutionRepository repository;
    final ModelMapper modelMapper = new ModelMapper();

    // private InstitutionDto convertToDto(Institution institution) {
    //     InstitutionDto institutionDto = modelMapper.map(institution, InstitutionDto.class);
    //     return institutionDto;
    // }
    // private Institution convertToEntity(InstitutionDto institutionDto) throws ParseException {
    //     Institution institution = modelMapper.map(institutionDto, Institution.class);
    //     return institution;
    // }
    
    public Institution createNewInstitution(Institution institution) {
        return repository.save(institution);
    }

    public List<InstitutionDto> listAllInstitutions(){
        List<InstitutionDto> institutionDto;
        List<Institution> institutions = repository.findAll();
        Type listType = new TypeToken<List<InstitutionDto>>() {}.getType();
        institutionDto = modelMapper.map(institutions, listType);
        return institutionDto;
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
