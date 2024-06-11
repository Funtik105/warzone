package com.example.warzone;

import com.example.warzone.controllers.exceptions.AttachmentConflictException;
import com.example.warzone.controllers.exceptions.AttachmentNotFoundException;
import com.example.warzone.dtos.AttachmentsDto;
import com.example.warzone.models.Attachments;
import com.example.warzone.repositories.AttachmentRepository;
import com.example.warzone.repositories.LoadoutGunRepository;
import com.example.warzone.servises.impl.AttachmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AttachmentServiceImplTests {

    @Mock
    private AttachmentRepository attachmentRepository;

    @Mock
    private LoadoutGunRepository loadoutGunRepository;

    @InjectMocks
    private AttachmentServiceImpl attachmentService;

    private ModelMapper modelMapper = new ModelMapper();

    private Attachments attachment1, attachment2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        attachment1 = new Attachments();
        attachment1.setId(1L);
        attachment1.setName("Attachment 1");
        attachment1.setGun(null);
        attachment1.setLevelsToOpen(10);
        attachment1.setDisadvantages(null);
        attachment1.setAdvantages(null);
        attachment1.setType("Sniper");
        attachment1.setLoadoutGun(null);
        attachment2 = new Attachments();
        attachment2.setId(2L);
        attachment2.setName("Attachment 2");
        attachment2.setGun(null);
        attachment2.setLevelsToOpen(20);
        attachment2.setDisadvantages(null);
        attachment2.setAdvantages(null);
        attachment2.setType("Assault");
        attachment2.setLoadoutGun(null);

        attachmentService = new AttachmentServiceImpl(attachmentRepository, loadoutGunRepository, modelMapper);
    }

    @Test
    void getAll() {
        List<Attachments> attachments = Arrays.asList(attachment1, attachment2);
        when(attachmentRepository.findAll()).thenReturn(attachments);

        List<AttachmentsDto> result = attachmentService.getAll();


        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(a -> a.getId().equals(attachment1.getId())));
        assertTrue(result.stream().anyMatch(a -> a.getId().equals(attachment2.getId())));
    }

    @Test
    void get() {
        when(attachmentRepository.findById(1L)).thenReturn(Optional.of(attachment1));

        Optional<AttachmentsDto> result = attachmentService.get(1L);

        assertTrue(result.isPresent());
        assertEquals(attachment1.getId(), result.get().getId());
    }

    @Test
    void register_newAttachment() {
        AttachmentsDto attachmentDto = modelMapper.map(attachment1, AttachmentsDto.class);
        when(attachmentRepository.findById(attachment1.getId())).thenReturn(Optional.empty());

        when(attachmentRepository.save(any(Attachments.class))).thenReturn(attachment1);

        AttachmentsDto result = attachmentService.register(attachmentDto);

        assertEquals(attachment1.getId(), result.getId());
    }

    @Test
    void register_existingAttachment() {
        AttachmentsDto attachmentDto = modelMapper.map(attachment1, AttachmentsDto.class);
        when(attachmentRepository.findById(attachment1.getId())).thenReturn(Optional.of(attachment1));

        assertThrows(AttachmentConflictException.class, () -> attachmentService.register(attachmentDto));
    }

    @Test
    void update_nonExistingAttachment() {
        AttachmentsDto attachmentDto = modelMapper.map(attachment1, AttachmentsDto.class);
        when(attachmentRepository.findById(attachment1.getId())).thenReturn(Optional.empty());

        assertThrows(AttachmentNotFoundException.class, () -> attachmentService.update(attachmentDto));
    }

    @Test
    void delete_existingAttachment() {
        when(attachmentRepository.findById(attachment1.getId())).thenReturn(Optional.of(attachment1));

        attachmentService.delete(attachment1.getId());

        verify(attachmentRepository, times(1)).deleteById(attachment1.getId());
    }

    @Test
    void delete_nonExistingAttachment() {
        when(attachmentRepository.findById(attachment1.getId())).thenReturn(Optional.empty());

        assertThrows(AttachmentNotFoundException.class, () -> attachmentService.delete(attachment1.getId()));
    }

    @Test
    void findAllByName() {
        List<Attachments> attachments = Arrays.asList(attachment1, attachment2);
        when(attachmentRepository.findAllByName(attachment1.getName())).thenReturn(attachments);

        List<AttachmentsDto> result = attachmentService.findAllByName(attachment1.getName());

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(a -> a.getId().equals(attachment1.getId())));
        assertTrue(result.stream().anyMatch(a -> a.getId().equals(attachment2.getId())));
    }

}