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
    private ModelMapper modelMapper;
    MetaListRepository metaListRepository;

    @Autowired
    public MetaListServiceImpl(MetaListRepository metaListRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
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

    @Override
    public List<MetaListDto> findAllByGun1(String gun1) {
        return metaListRepository.findAllByGun1(gun1).stream().map((s)-> modelMapper.map(s,MetaListDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MetaListDto> findAllByName(String name) {
        return metaListRepository.findAllByName(name).stream().map((s)-> modelMapper.map(s,MetaListDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MetaListDto> findAllByRange(String range) {
        return metaListRepository.findAllByRange(range).stream().map((s)-> modelMapper.map(s,MetaListDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MetaListDto> findAllByCategory(String category) {
        return metaListRepository.findAllByCategory(category).stream().map((s)-> modelMapper.map(s,MetaListDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MetaListDto> findAllByAttachment_1(String attachment_1) {
        return metaListRepository.findAllByAttachment_1(attachment_1).stream().map((s)-> modelMapper.map(s,MetaListDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MetaListDto> findAllByAttachment_2(String attachment_2) {
        return metaListRepository.findAllByAttachment_2(attachment_2).stream().map((s)-> modelMapper.map(s,MetaListDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MetaListDto> findAllByAttachment_3(String attachment_3) {
        return metaListRepository.findAllByAttachment_3(attachment_3).stream().map((s)-> modelMapper.map(s,MetaListDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MetaListDto> findAllByAttachment_4(String attachment_4) {
        return metaListRepository.findAllByAttachment_4(attachment_4).stream().map((s)-> modelMapper.map(s,MetaListDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MetaListDto> findAllByAttachment_5(String attachment_5) {
        return metaListRepository.findAllByAttachment_5(attachment_5).stream().map((s)-> modelMapper.map(s,MetaListDto.class)).collect(Collectors.toList());
    }
}
