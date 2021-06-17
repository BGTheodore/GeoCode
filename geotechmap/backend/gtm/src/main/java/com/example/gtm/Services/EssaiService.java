package com.example.gtm.Services;


import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.gtm.Entities.Essai;
import com.example.gtm.Exception.ResourceNotFoundException;
import com.example.gtm.Repositories.EssaiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dto.Essai.EssaiDto;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.example.gtm.Entities.Position;



@Service
public class EssaiService {
    @Autowired
    EssaiRepository repository;



    final ModelMapper modelMapper = new ModelMapper();
    
    private EssaiDto convertToDto(Essai essai) {
        EssaiDto essaiDto = modelMapper.map(essai, EssaiDto.class);
        // essaiDto.setSubmissionDate(essai.getSubmissionDate(), 
        //     userService.getCurrentUser().getPreference().getTimezone());
        return essaiDto;
    }
    private Essai convertToEntity(EssaiDto essaiDto) throws ParseException {
        Essai essai = modelMapper.map(essaiDto, Essai.class);
        // essai.setSubmissionDate(EssaiDto.getSubmissionDateConverted(
        //   userService.getCurrentUser().getPreference().getTimezone()));
     
        // if (EssaiDto.getId() != null) {
        //     Post oldPost = postService.getPostById(EssaiDto.getId());
        //     post.setRedditID(oldPost.getRedditID());
        //     post.setSent(oldPost.isSent());
        // }
        return essai;
    }
    
    public EssaiDto createNewEssai(EssaiDto essaiDto) throws ParseException {
        Essai essai = convertToEntity(essaiDto);
        Essai essaiCreated =  repository.save(essai);
        return convertToDto(essaiCreated);
        }

    public List<EssaiDto> listAllEssais() {
        List<EssaiDto> essaiDto;
        List<Essai> essais = repository.findAll();
        Type listType = new TypeToken<List<EssaiDto>>() {}.getType();
        essaiDto = modelMapper.map(essais, listType);
        return essaiDto;
        }

    public List<Essai> getAllEssaisRegroupeParCategorie() {
        return repository.getAllEssaisRegroupeParCategorie();
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

    //============================

    public Position genererStucturePosition(@Valid EssaiDto essai) {
        
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(essai.getPosition().getLatitude(), essai.getPosition().getLongitude());
        Point point = geometryFactory.createPoint(coordinate);
        point.setSRID(3857);//Nous devons choisir un SRID (old 4326) WGS84
        Position position = essai.getPosition();
        position.setGeom(point);
        position.setLatitude(essai.getPosition().getLatitude());
        position.setLongitude(essai.getPosition().getLongitude());
        position.setAltitude(essai.getPosition().getAltitude());
        position.setDepartement(essai.getPosition().getDepartement());
        position.setCommune(essai.getPosition().getCommune());
        position.setSectionCommunale(essai.getPosition().getSectionCommunale());
        return position;
        
    }

}
