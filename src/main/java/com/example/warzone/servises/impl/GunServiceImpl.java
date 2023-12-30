package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.GunNotFoundException;
import com.example.warzone.dtos.gunservice.GunDto;
import com.example.warzone.models.Gun;
import com.example.warzone.repositories.GunRepository;
import com.example.warzone.servises.GunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GunServiceImpl implements GunService{
    GunRepository gunRepository;

    @Autowired
    public GunServiceImpl(GunRepository gunRepository) {
        this.gunRepository = gunRepository;
    }

    @Override
    public List<GunDto> getAll() {
        List<Gun> gunEntities = gunRepository.findAll();
        List<GunDto> guns = new ArrayList<>();
        for (Gun entity : gunEntities) {
            GunDto gun = new GunDto();
            gun.setId(entity.getId());
            gun.setName(entity.getName());
            gun.setCategory(entity.getCategory());
            gun.setGameRepresents(entity.getGameRepresents());
            guns.add(gun);
        }
        return guns;
    }

    @Override
    public Optional<GunDto> get(Long id) {
        return gunRepository.findById(id)
                .map(entity -> {
                    GunDto gun = new GunDto();
                    gun.setId(entity.getId());
                    gun.setName(entity.getName());
                    gun.setCategory(entity.getCategory());
                    gun.setGameRepresents(entity.getGameRepresents());
                    return gun;
                });
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
    public Optional<GunDto> findByName(String name) {
        return gunRepository.findByName(name)
                .map(entity -> {
                    GunDto gun = new GunDto();
                    gun.setId(entity.getId());
                    gun.setName(entity.getName());
                    gun.setCategory(entity.getCategory());
                    gun.setGameRepresents(entity.getGameRepresents());
                    return gun;
                });
    }

    @Override
    public List<GunDto> findByCategory(String category) {
        List<Gun> gunEntities = gunRepository.findByCategory(category);
        List<GunDto> guns = new ArrayList<>();
        for (Gun entity : gunEntities) {
            GunDto gun = new GunDto();
            gun.setId(entity.getId());
            gun.setName(entity.getName());
            gun.setCategory(entity.getCategory());
            gun.setGameRepresents(entity.getGameRepresents());
            guns.add(gun);
        }
        return guns;
    }

    @Override
    public List<GunDto> findByGameRepresents(String gameRepresents) {
        List<Gun> gunEntities = gunRepository.findByGameRepresents(gameRepresents);
        List<GunDto> guns = new ArrayList<>();
        for (Gun entity : gunEntities) {
            GunDto gun = new GunDto();
            gun.setId(entity.getId());
            gun.setName(entity.getName());
            gun.setCategory(entity.getCategory());
            gun.setGameRepresents(entity.getGameRepresents());
            guns.add(gun);
        }
        return guns;
    }
}
