package com.example.gtm.Services;

import java.util.List;
import java.util.Optional;
import com.example.gtm.Exception.ResourceNotFoundException;
import com.example.gtm.Entities.Position;
import com.example.gtm.Repositories.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    @Autowired
    PositionRepository repository;

    public Position createNewPosition(Position position) {
        return repository.save(position);
    }

    public List<Position> listAllPositions() {
        return repository.findAll();
        }

    public Position updatePosition(Long id, Position position){
        Optional<Position> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new ResourceNotFoundException("Position not found with id :" + id );
        } else {
            position.setId(id);
            return repository.save(position);
        }
    }

    public void deletePosition(Long id) {
        Optional<Position> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new ResourceNotFoundException("Position not found with id :" + id );
        } else {
            repository.deleteById(id);
        }
    }

    public Optional<Position> getPosition(Long id) {
        Optional<Position> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new ResourceNotFoundException("Position not found with id :" + id );
        } else {
            return optional;
        }
    }
}