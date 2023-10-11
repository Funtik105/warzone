package com.example.warzone.servises.impl;

import com.example.warzone.controllers.exceptions.AttachmentConflictException;
import com.example.warzone.controllers.exceptions.AttachmentNotFoundException;
import com.example.warzone.dtos.AttachmentsDto;
import com.example.warzone.models.Attachments;
import com.example.warzone.repositories.AttachmentRepository;
import com.example.warzone.servises.AttachmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository){ this.attachmentRepository = attachmentRepository; }
    @Override
    public List<AttachmentsDto> getAll(){
        return attachmentRepository.findAll().stream().map((s)->modelMapper.map(s,AttachmentsDto.class)).collect(Collectors.toList());
    }
    @Override
    public Optional<AttachmentsDto> get(Long id){
        return Optional.ofNullable(modelMapper.map(attachmentRepository.findById(id),AttachmentsDto.class));
    }
    @Override
    public AttachmentsDto register(AttachmentsDto attachmentsDto){
        Attachments attachments = modelMapper.map(attachmentsDto,Attachments.class);
        if(attachments.getId() == null || attachments.getId() == 0 || get(attachments.getId()).isEmpty()){
            return modelMapper.map(attachmentRepository.save(attachments),AttachmentsDto.class);
        }
        else {
            throw new AttachmentConflictException("A attachment with this id already exists");
        }
    }
    @Override
    public AttachmentsDto update(AttachmentsDto attachmentsDto){
        if (attachmentRepository.findById(attachmentsDto.getId()).isPresent()) {
            return modelMapper.map(attachmentRepository.save(modelMapper.map(attachmentsDto, Attachments.class)),AttachmentsDto.class);
        } else {
            throw new AttachmentNotFoundException(attachmentsDto.getId());
        }
    }

    @Override
    public void delete(Long id) {
        if (attachmentRepository.findById(id).isPresent()) {
            attachmentRepository.deleteById(id);
        } else {
            throw new AttachmentNotFoundException(id);
        }
    }
}