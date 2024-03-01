package com.example.warzone.servises.impl;

import com.example.warzone.dtos.CamoDto;
import com.example.warzone.models.Camo;
import com.example.warzone.models.Gun;
import com.example.warzone.repositories.CamoRepository;
import com.example.warzone.servises.CamoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CamoServiceImpl implements CamoService {
    private final CamoRepository camoRepository;
    private final ModelMapper modelMapper;

    public CamoServiceImpl(CamoRepository camoRepository, ModelMapper modelMapper) {
        this.camoRepository = camoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CamoDto> getAll() {
        return camoRepository.findAll().stream()
                .map((s) -> modelMapper.map(s, CamoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CamoDto> get(Long id) {
        return camoRepository.findById(id).map(camo -> modelMapper.map(camo, CamoDto.class));
    }

    @Override
    public CamoDto register(CamoDto camoDto) {
        Camo camo = modelMapper.map(camoDto, Camo.class);

        Camo savedCamo = camoRepository.save(camo);

        camoDto.setId(savedCamo.getId());

        return camoDto;
    }

    @Override
    public CamoDto update(CamoDto camoDto) {
        Camo camo = modelMapper.map(camoDto, Camo.class);
        return modelMapper.map(camoRepository.save(camo), CamoDto.class);
    }

    @Override
    public List<CamoDto> findByGameRepresents(String gameRepresents) {
        return camoRepository.findByGameRepresents(gameRepresents).stream()
                .map(camo -> modelMapper.map(camo, CamoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CamoDto> findCamosByTitle(String title) {
        return camoRepository.findCamosByTitle(title).stream()
                .map(camo -> modelMapper.map(camo, CamoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CamoDto> findCamosByStatus(boolean status) {
        return camoRepository.findCamosByStatus(status).stream()
                .map(camo -> modelMapper.map(camo, CamoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CamoDto> findByGunName(String gunName) {
        return camoRepository.findByGunName(gunName).stream()
                .map(camo -> modelMapper.map(camo, CamoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CamoDto> findCamosByGunId(Long gun_id) {
        return camoRepository.findCamosByGunId(gun_id).stream()
                .map(camo -> modelMapper.map(camo,CamoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        camoRepository.deleteById(id);
    }
}
