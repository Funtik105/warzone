package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.LoadoutGunConflictException;
import com.example.warzone.controllers.exceptions.LoadoutGunNotFoundException;
import com.example.warzone.dtos.LoadoutGunDto;
import com.example.warzone.models.*;
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
    private ModelMapper modelMapper;
    LoadoutGunRepository loadoutGunRepository;

    @Autowired
    public LoadoutGunServiceImpl(LoadoutGunRepository loadoutGunRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.loadoutGunRepository = loadoutGunRepository;
    }

    @Override
    public List<LoadoutGunDto> getAll() {
        return loadoutGunRepository.findAll().stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<LoadoutGunDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(loadoutGunRepository.findById(id), LoadoutGunDto.class));
    }

    @Override
    public LoadoutGunDto register(LoadoutGunDto loadoutGunDto) {
        LoadoutGun loadoutGun = modelMapper.map(loadoutGunDto, LoadoutGun.class);
        if (loadoutGun.getId() == null || loadoutGun.getId() == 0 || get(loadoutGun.getId()).isEmpty()) {
            return modelMapper.map(loadoutGunRepository.save(loadoutGun), LoadoutGunDto.class);
        } else {
            throw new LoadoutGunConflictException("A loadoutgun with this id already exists");
        }
    }

    @Override
    public LoadoutGunDto update(LoadoutGunDto loadoutGunDto) {
        if (loadoutGunRepository.findById(loadoutGunDto.getId()).isPresent()) {
            return modelMapper.map(loadoutGunRepository.save(modelMapper.map(loadoutGunDto, LoadoutGun.class)), LoadoutGunDto.class);
        } else {
            throw new LoadoutGunNotFoundException(loadoutGunDto.getId());
        }
    }

    @Override
    public void delete(Long id) {
        if (loadoutGunRepository.findById(id).isPresent()) {
            loadoutGunRepository.deleteById(id);
        } else {
            throw new LoadoutGunNotFoundException(id);
        }

    }

    @Override
    public List<LoadoutGunDto> findAllByName(String name) {
        return loadoutGunRepository.findAllByName(name).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByRange(String range) {
        return loadoutGunRepository.findAllByRange(range).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByAttachment_1(String attachment_1) {
        return loadoutGunRepository.findAllByAttachment_1(attachment_1).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByAttachment_2(String attachment_2) {
        return loadoutGunRepository.findAllByAttachment_2(attachment_2).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByAttachment_3(String attachment_3) {
        return loadoutGunRepository.findAllByAttachment_3(attachment_3).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByAttachment_4(String attachment_4) {
        return loadoutGunRepository.findAllByAttachment_4(attachment_4).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByAttachment_5(String attachment_5) {
        return loadoutGunRepository.findAllByAttachment_5(attachment_5).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByAttachment_customization_1(String attachment_customization_1) {
        return loadoutGunRepository.findAllByAttachment_customization_1(attachment_customization_1).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByAttachment_customization_2(String attachment_customization_2) {
        return loadoutGunRepository.findAllByAttachment_customization_2(attachment_customization_2).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByAttachment_customization_3(String attachment_customization_3) {
        return loadoutGunRepository.findAllByAttachment_customization_3(attachment_customization_3).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByAttachment_customization_4(String attachment_customization_4) {
        return loadoutGunRepository.findAllByAttachment_customization_4(attachment_customization_4).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<LoadoutGunDto> findAllByAttachment_customization_5(String attachment_customization_5) {
        return loadoutGunRepository.findAllByAttachment_customization_5(attachment_customization_5).stream().map((s) -> modelMapper.map(s, LoadoutGunDto.class)).collect(Collectors.toList());
    }
}