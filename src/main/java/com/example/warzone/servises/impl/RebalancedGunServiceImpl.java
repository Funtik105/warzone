package com.example.warzone.servises.impl;

import com.example.warzone.dtos.GunDto;
import com.example.warzone.dtos.NerfsAndBuffsDto;
import com.example.warzone.dtos.RebalancedGunDto;
import com.example.warzone.models.Gun;
import com.example.warzone.models.NerfsAndBuffs;
import com.example.warzone.models.RebalancedGun;
import com.example.warzone.repositories.GunRepository;
import com.example.warzone.repositories.NerfsAndBuffsRepository;
import com.example.warzone.repositories.RebalancedGunRepository;
import com.example.warzone.servises.RebalancedGunService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RebalancedGunServiceImpl implements RebalancedGunService {
    private RebalancedGunRepository rebalancedGunRepository;
    private NerfsAndBuffsRepository nerfsAndBuffsRepository;
    private GunRepository gunRepository;
    private ModelMapper modelMapper;

    @Autowired
    public RebalancedGunServiceImpl(RebalancedGunRepository rebalancedGunRepository, NerfsAndBuffsRepository nerfsAndBuffsRepository, GunRepository gunRepository, ModelMapper modelMapper) {
        this.rebalancedGunRepository = rebalancedGunRepository;
        this.nerfsAndBuffsRepository = nerfsAndBuffsRepository;
        this.gunRepository = gunRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RebalancedGunDto> getAll() {
        return rebalancedGunRepository.findAll().stream()
                .map((s) -> modelMapper.map(s, RebalancedGunDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<RebalancedGunDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(rebalancedGunRepository.findById(id), RebalancedGunDto.class));
    }

    @Override
    public RebalancedGunDto register(RebalancedGunDto rebalancedGunDto) {
        RebalancedGun rebalancedGun = modelMapper.map(rebalancedGunDto, RebalancedGun.class);
        rebalancedGun.setGun(gunRepository.findById(rebalancedGunDto.getId()).orElse(null));
        rebalancedGun.setNerfsAndBuffs(nerfsAndBuffsRepository.findById(rebalancedGunDto.getId()).orElse(null));

        return modelMapper.map(rebalancedGunRepository.save(rebalancedGun), RebalancedGunDto.class);
    }

    @Override
    public void delete(Long id) {
        if (rebalancedGunRepository.findById(id).isPresent()) {
            rebalancedGunRepository.deleteById(id);
        }
    }

}
