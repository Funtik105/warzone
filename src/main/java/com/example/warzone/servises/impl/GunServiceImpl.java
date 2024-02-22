package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.GunConflictException;
import com.example.warzone.controllers.exceptions.GunNotFoundException;
import com.example.warzone.dtos.gunservice.GunDto;
import com.example.warzone.models.Gun;
import com.example.warzone.repositories.GameRepresentRepository;
import com.example.warzone.repositories.GunRepository;
import com.example.warzone.servises.GunService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GunServiceImpl implements GunService{

    private ModelMapper modelMapper;
    GunRepository gunRepository;

    @Autowired
    public GunServiceImpl(GunRepository gunRepository) {
        this.gunRepository = gunRepository;
    }

    @Override
    public List<GunDto> getAll() {
        return gunRepository.findAll().stream().map((s)-> modelMapper.map(s, GunDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<GunDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(gunRepository.findById(id), GunDto.class));
    }

    @Override
    public GunDto register(GunDto gunDto) {
        Gun gun = modelMapper.map(gunDto, Gun.class);
        if (gun.getId() == null || gun.getId() == 0 || get(gun.getId()).isEmpty()) {
            return modelMapper.map(gunRepository.save(gun), GunDto.class);
        } else {
            throw new GunConflictException("A gun with this id already exists");
        }
    }

    @Override
    public Optional<GunDto> editByName(String name, GunDto updatedGun) {
        if (gunRepository.findById(updatedGun.getId()).isPresent()) {
            return Optional.ofNullable(modelMapper.map(gunRepository.save(modelMapper.map(updatedGun, Gun.class)), GunDto.class));
        } else {
            throw new GunNotFoundException(updatedGun.getId());
        }
    }

    @Override
    public void delete(Long id) {
        if (gunRepository.findById(id).isPresent()) {
            gunRepository.deleteById(id);
        } else {
            throw new GunNotFoundException(id);
        }
    }

    @Override
    public Optional<GunDto> findByName(String name) {
        return Optional.ofNullable(gunRepository.findByName(name).map((s) -> modelMapper.map(s, GunDto.class)).orElse(null));
    }

    @Override
    public List<GunDto> findByCategory(String category) {
        return gunRepository.findByCategory(category).stream().map((s) -> modelMapper.map(s, GunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<GunDto> findByGameRepresents(String gameRepresents) {
        return gunRepository.findByGameRepresents(gameRepresents).stream().map((s) -> modelMapper.map(s, GunDto.class)).collect(Collectors.toList());
    }
}
