package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.LoadoutNotFoundException;
import com.example.warzone.controllers.exceptions.NerfsAndBuffsConflictException;
import com.example.warzone.controllers.exceptions.NerfsAndBuffsNotFoundException;
import com.example.warzone.dtos.NerfsAndBuffsDto;
import com.example.warzone.models.NerfsAndBuffs;
import com.example.warzone.repositories.NerfsAndBuffsRepository;
import com.example.warzone.servises.NerfsAndBuffsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NerfsAndBuffsServiceImpl implements NerfsAndBuffsService {
    private ModelMapper modelMapper;
    private final NerfsAndBuffsRepository nerfsAndBuffsRepository;

    @Autowired
    public NerfsAndBuffsServiceImpl(NerfsAndBuffsRepository nerfsAndBuffsRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.nerfsAndBuffsRepository = nerfsAndBuffsRepository;
    }

    @Override
    public List<NerfsAndBuffsDto> getAll() {
        return nerfsAndBuffsRepository.findAll().stream()
                .map((s) -> modelMapper.map(s, NerfsAndBuffsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NerfsAndBuffsDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(nerfsAndBuffsRepository.findById(id), NerfsAndBuffsDto.class));
    }

    @Override
    public NerfsAndBuffsDto register(NerfsAndBuffsDto nerfsAndBuffsDto) {
        NerfsAndBuffs nerfsAndBuffs = modelMapper.map(nerfsAndBuffsDto, NerfsAndBuffs.class);

        NerfsAndBuffs savedNerfsAndBuffs = nerfsAndBuffsRepository.save(nerfsAndBuffs);

        nerfsAndBuffsDto.setId(savedNerfsAndBuffs.getId());

        return nerfsAndBuffsDto;
    }

    @Override
    public NerfsAndBuffsDto update(NerfsAndBuffsDto nerfsAndBuffsDto) {
        if (nerfsAndBuffsRepository.findById(nerfsAndBuffsDto.getId()).isPresent()) {
            return modelMapper.map(nerfsAndBuffsRepository.save(modelMapper.map(nerfsAndBuffsDto, NerfsAndBuffs.class)), NerfsAndBuffsDto.class);
        } else {
            throw new NerfsAndBuffsNotFoundException(nerfsAndBuffsDto.getId());
        }
    }

    @Override
    public void delete(Long id) {
        if (nerfsAndBuffsRepository.findById(id).isPresent()) {
            nerfsAndBuffsRepository.deleteById(id);
        } else {
            throw new LoadoutNotFoundException(id);
        }
    }

    @Override
    public List<NerfsAndBuffsDto> findAllByDate(String date) {
        return nerfsAndBuffsRepository.findAllByDate(date).stream().map((s) -> modelMapper.map(s, NerfsAndBuffsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<NerfsAndBuffsDto> findAllByNameGun(String nameGun) {
        return nerfsAndBuffsRepository.findAllByNameGun(nameGun).stream().map((s) -> modelMapper.map(s, NerfsAndBuffsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<NerfsAndBuffsDto> findAllByStatus(boolean status) {
        return nerfsAndBuffsRepository.findAllByStatus(status).stream().map((s) -> modelMapper.map(s, NerfsAndBuffsDto.class)).collect(Collectors.toList());
    }
}