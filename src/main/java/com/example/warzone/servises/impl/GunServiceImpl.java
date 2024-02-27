package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.GunNotFoundException;
import com.example.warzone.dtos.gunservice.GunDto;
import com.example.warzone.models.Gun;
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
    GunRepository gunRepository;
    private ModelMapper modelMapper;

    @Autowired
    public GunServiceImpl(GunRepository gunRepository, ModelMapper modelMapper) {
        this.gunRepository = gunRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GunDto> getAll() {
        return gunRepository.findAll().stream().map((s) -> modelMapper.map(s, GunDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<GunDto> get(Long id) {
        return gunRepository.findById(id).map((s) -> modelMapper.map(s, GunDto.class));
    }

    @Override
    public GunDto register(GunDto gun) {
        Gun newGun = new Gun();
        newGun.setName(gun.getName());
        newGun.setCategory(gun.getCategory());
        newGun.setGameRepresents(gun.getGameRepresents());
        Gun savedEntity = gunRepository.save(newGun);

        gun.setId(savedEntity.getId()); // Установка сгенерированного ID
        return gun;
    }

    @Override
    public Optional<GunDto> editByName(String name, GunDto updatedGun) {
        Optional<Gun> existingGun = gunRepository.findByName(name);
        return existingGun.map(entity -> {
            entity.setName(updatedGun.getName());
            entity.setCategory(updatedGun.getCategory());
            entity.setGameRepresents(updatedGun.getGameRepresents());
            Gun updatedEntity = gunRepository.save(entity);

            updatedGun.setId(updatedEntity.getId());
            updatedGun.setName(updatedEntity.getName());
            updatedGun.setCategory(updatedEntity.getCategory());
            updatedGun.setGameRepresents(updatedEntity.getGameRepresents());
            return updatedGun;
        });
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
    public List<GunDto> findByName(String name) {
        return gunRepository.findByName(name).stream().map((s) -> modelMapper.map(s, GunDto.class)).collect(Collectors.toList());
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
