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
import java.text.ParseException;

@Service
public class InstitutionService {
    @Autowired
    InstitutionRepository repository;

    final ModelMapper modelMapper = new ModelMapper();
  
    private InstitutionDto convertToDto(Institution institution) {
        InstitutionDto institutionDto = modelMapper.map(institution, InstitutionDto.class);
        return institutionDto;
    }

    private Institution convertToEntity(InstitutionDto institutionDto) throws ParseException {
        Institution institution = modelMapper.map(institutionDto, Institution.class);
        return institution;
    }
    //_________________________
    
    public InstitutionDto createNewInstitution(InstitutionDto institutionDto) throws ParseException{
        Institution institution = convertToEntity(institutionDto);
        Institution intitutionCreated = repository.save(institution);
        return convertToDto(intitutionCreated);
    }

    public List<InstitutionDto> listAllInstitutions(){
        List<InstitutionDto> institutionDto;
        List<Institution> institutions = repository.findAll();
        Type listType = new TypeToken<List<InstitutionDto>>() {}.getType();
        institutionDto = modelMapper.map(institutions, listType);
        return institutionDto;
    }

    public InstitutionDto updateInstitution(Long id, InstitutionDto institutionDto) throws ParseException{
        Optional<Institution> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new ResourceNotFoundException("Institution not found with id :" + id );
        } else {
            Institution institution = convertToEntity(institutionDto);
            institution.setId(id);// je dois mettre l'id dans le body et enlever ca en parametre
            return convertToDto(repository.save(institution));
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

    public InstitutionDto getInstitution(Long id) {
        Optional<Institution> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new ResourceNotFoundException("Institution not found with id :" + id );
        } else {
            return convertToDto(optional.get());
        }
    }
}
