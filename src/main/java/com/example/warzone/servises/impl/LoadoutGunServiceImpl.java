package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.LoadoutGunConflictException;
import com.example.warzone.controllers.exceptions.LoadoutGunNotFoundException;
import com.example.warzone.dtos.LoadoutGunDto;
import com.example.warzone.models.LoadoutGun;
import com.example.warzone.repositories.LoadoutGunRepository;
import com.example.warzone.servises.LoadoutGunService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class LoadoutGunServiceImpl implements LoadoutGunService {
    @Autowired
    LoadoutGunRepository loadoutGunRepository;
    private ModelMapper modelMapper;

    public LoadoutGunServiceImpl(LoadoutGunRepository loadoutGunRepository) {
        this.loadoutGunRepository = loadoutGunRepository;
    }

    @Override
    public List<LoadoutGunDto> getAll() {
        return loadoutGunRepository.findAll().stream().map((s)->modelMapper.map(s,LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<LoadoutGunDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(loadoutGunRepository.findById(id),LoadoutGunDto.class));
    }

    @Override
    public LoadoutGunDto register(LoadoutGunDto loadoutGunDto) {
        LoadoutGun loadoutGun = modelMapper.map(loadoutGunDto,LoadoutGun.class);
        if(loadoutGun.getId() == null || loadoutGun.getId() == 0 || get(loadoutGun.getId()).isEmpty()) {
            return modelMapper.map(loadoutGunRepository.save(loadoutGun), LoadoutGunDto.class);
        } else {
            throw new LoadoutGunConflictException("A loadoutgun with this id already exists");
        }
    }

    @Override
    public LoadoutGunDto update(LoadoutGunDto loadoutGunDto) {
        if (loadoutGunRepository.findById(loadoutGunDto.getId()).isPresent()) {
            return modelMapper.map(loadoutGunRepository.save(modelMapper.map(loadoutGunDto, LoadoutGun.class)),LoadoutGunDto.class);
        } else {
            throw new LoadoutGunNotFoundException(loadoutGunDto.getId());
        }
    }

    @Override
    public void delete(Long id) {
        if (loadoutGunRepository.findById(id).isPresent()){
            loadoutGunRepository.deleteById(id);
        } else {
            throw new LoadoutGunNotFoundException(id);
        }

    }
}
