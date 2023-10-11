package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.GunConflictException;
import com.example.warzone.controllers.exceptions.GunNotFoundException;
import com.example.warzone.dtos.GunDto;
import com.example.warzone.models.Gun;
import com.example.warzone.repositories.GunRepository;
import com.example.warzone.servises.GunService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class GunServiceImpl implements GunService {
    @Autowired
    GunRepository gunRepository;
    @Autowired
    private ModelMapper modelMapper;

    public GunServiceImpl(GunRepository gunRepository){this.gunRepository = gunRepository;}
    @Override
    public List<GunDto> getAll() {
        return gunRepository.findAll().stream().map((s) -> modelMapper.map(s,GunDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<GunDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(gunRepository.findById(id),GunDto.class));
    }

    @Override
    public GunDto register(GunDto gunDto) {
        Gun gun = modelMapper.map(gunDto,Gun.class);
        if(gunDto.getId() == null || gun.getId() == 0 || get(gun.getId()).isEmpty()){
            return modelMapper.map(gunRepository.save(gun),GunDto.class);
        } else {
            throw new GunConflictException("A gun with this id already exists");
        }
    }

    @Override
    public GunDto update(GunDto gunDto) {
        if(gunRepository.findById(gunDto.getId()).isPresent()){
            return modelMapper.map(gunRepository.save(modelMapper.map(gunDto,Gun.class)), GunDto.class);
        } else {
            throw new GunNotFoundException(gunDto.getId());
        }
    }

    @Override
    public void delete(Long id) {
        if (gunRepository.findById(id).isPresent()){
            gunRepository.deleteById(id);
        } else {
            throw new GunNotFoundException(id);
        }
    }
}
