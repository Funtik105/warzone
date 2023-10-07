package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.LoadoutConflictException;
import com.example.warzone.controllers.exceptions.LoadoutNotFoundException;
import com.example.warzone.dtos.LoadoutDto;
import com.example.warzone.models.Loadout;
import com.example.warzone.repositories.LoadoutRepository;
import com.example.warzone.servises.LoadoutService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoadoutServiceImpl implements LoadoutService {
    @Autowired
    LoadoutRepository loadoutRepository;
    private ModelMapper modelMapper;
    public LoadoutServiceImpl(LoadoutRepository loadoutRepository){
        this.loadoutRepository = loadoutRepository;
    }
    @Override
    public List<LoadoutDto> getAll() {
        return loadoutRepository.findAll().stream().map((s)->modelMapper.map(s,LoadoutDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<LoadoutDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(loadoutRepository.findById(id),LoadoutDto.class));
    }

    @Override
    public LoadoutDto register(LoadoutDto loadoutDto) {
        Loadout loadout = modelMapper.map(loadoutDto, Loadout.class);
        if (loadout.getId() == null || loadout.getId() == 0 || get(loadout.getId()).isEmpty()){
            return modelMapper.map(loadoutRepository.save(loadout),LoadoutDto.class);
        } else {
            throw new LoadoutConflictException("A loadout with this id already exists");
        }
    }

    @Override
    public LoadoutDto update(LoadoutDto loadoutDto) {
        if (loadoutRepository.findById(loadoutDto.getId()).isPresent()){
            return  modelMapper.map(loadoutRepository.save(modelMapper.map(loadoutDto, Loadout.class)),LoadoutDto.class);
        } else {
            throw new LoadoutNotFoundException(loadoutDto.getId());
        }
    }

    @Override
    public void delete(Long id) {
        if (loadoutRepository.findById(id).isPresent()){
            loadoutRepository.deleteById(id);
        } else {
            throw new LoadoutNotFoundException(id);
        }
    }
}
