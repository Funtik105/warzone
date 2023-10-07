package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.MetaListConflictException;
import com.example.warzone.controllers.exceptions.MetaListNotFoundException;
import com.example.warzone.dtos.MetaListDto;
import com.example.warzone.models.MetaList;
import com.example.warzone.repositories.MetaListRepository;
import com.example.warzone.servises.MetaListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MetaListServiceImpl implements MetaListService {
    @Autowired
    MetaListRepository metaListRepository;
    private ModelMapper modelMapper;

    public MetaListServiceImpl(MetaListRepository metaListRepository) {
        this.metaListRepository = metaListRepository;
    }

    @Override
    public List<MetaListDto> getAlL() {
        return metaListRepository.findAll().stream().map((s)-> modelMapper.map(s,MetaListDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<MetaListDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(metaListRepository.findById(id),MetaListDto.class));
    }

    @Override
    public MetaListDto register(MetaListDto metaListDto) {
        MetaList metaList = modelMapper.map(metaListDto,MetaList.class);
        if (metaList.getId() == null || metaList.getId() == 0 || get(metaList.getId()).isEmpty()){
            return modelMapper.map(metaListRepository.save(metaList),MetaListDto.class);
        } else {
            throw new MetaListConflictException("A metalist with this id already exists");
        }
    }

    @Override
    public MetaListDto update(MetaListDto metaListDto) {
        if (metaListRepository.findById(metaListDto.getId()).isPresent()){
            return modelMapper.map(metaListRepository.save(modelMapper.map(metaListDto, MetaList.class)),MetaListDto.class);
        } else {
            throw new MetaListNotFoundException(metaListDto.getId());
        }
    }

    @Override
    public void delete(Long id) {
        if (metaListRepository.findById(id).isPresent()){
            metaListRepository.deleteById(id);
        } else {
            throw new MetaListNotFoundException(id);
        }
    }
}
