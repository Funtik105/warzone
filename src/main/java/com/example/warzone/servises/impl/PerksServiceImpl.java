package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.PerksConflictException;
import com.example.warzone.controllers.exceptions.PerksNotFoundException;
import com.example.warzone.dtos.PerksDto;
import com.example.warzone.models.Perks;
import com.example.warzone.repositories.PerksRepository;
import com.example.warzone.servises.PerksService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PerksServiceImpl implements PerksService {
    @Autowired
    PerksRepository perksRepository;
    @Autowired
    private ModelMapper modelMapper;
    public PerksServiceImpl(PerksRepository perksRepository){
        this.perksRepository = perksRepository;
    }
    @Override
    public List<PerksDto> getAll() {
        return perksRepository.findAll().stream().map((s)->modelMapper.map(s, PerksDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<PerksDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(perksRepository.findById(id),PerksDto.class));
    }

    @Override
    public PerksDto register(PerksDto perksDto) {
        Perks perks = modelMapper.map(perksDto,Perks.class);
        if (perks.getId() == null || perks.getId() == 0 || get(perks.getId()).isEmpty()){
            return modelMapper.map(perksRepository.save(perks), PerksDto.class);
        } else {
            throw new PerksConflictException("A perk with this id already exists"); // додлелать ошибку
        }
    }

    @Override
    public PerksDto update(PerksDto perksDto) {
        if (perksRepository.findById(perksDto.getId()).isPresent()){
            return modelMapper.map(perksRepository.save(modelMapper.map(perksDto,Perks.class)), PerksDto.class);
        } else {
            throw new PerksNotFoundException(perksDto.getId());
        }
    }

    @Override
    public void delete(Long id) {
        if (perksRepository.findById(id).isPresent()){
            perksRepository.deleteById(id);
        } else {
            throw new PerksNotFoundException(id);
        }
    }
}
