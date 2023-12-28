package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.AttachmentNotFoundException;
import com.example.warzone.dtos.AttachmentsDto;
import com.example.warzone.servises.AttachmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Attachments", description = "API для вложений")
@RestController
@RequestMapping("/attachments")
public class AttachmentController{
    private AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @Operation(summary = "Получить все")
    @GetMapping()
    List<AttachmentsDto> all() {
        return attachmentService.getAll();
    }

    @Operation(summary = "Получить по id")
    @GetMapping("/{id}")
    AttachmentsDto get(@PathVariable Long id) {
        return attachmentService.get(id).orElseThrow(() -> new AttachmentNotFoundException(id));
    }

    @Operation(summary = "Создание")
    @PostMapping()
    AttachmentsDto create(@RequestBody AttachmentsDto attachmentsDto) {
        return attachmentService.register(attachmentsDto);
    }

    @Operation(summary = "Обновление")
    @PutMapping()
    AttachmentsDto update(@RequestBody AttachmentsDto attachmentsDto) {
        return attachmentService.update(attachmentsDto);
    }

    @Operation(summary = "Удаление")
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        attachmentService.delete(id);
    }

    @Operation(summary = "Получить все по названию")
    @GetMapping("/byName")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentByName(@RequestParam String name) {
        List<AttachmentsDto> attachments = attachmentService.findAllByName(name);
        return ResponseEntity.ok(attachments);
    }

    @Operation(summary = "Получить все по оружию")
    @GetMapping("/byWeapons")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentByWeaponsToOpen(@RequestParam String weaponsToOpen) {
        List<AttachmentsDto> attachments = attachmentService.findAllByWeaponsToOpen(weaponsToOpen);
        return ResponseEntity.ok(attachments);
    }

    @Operation(summary = "Получить все по уровню")
    @GetMapping("/byLevels")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentByLevelsToOpen(@RequestParam short levelsToOpen) {
        List<AttachmentsDto> attachments = attachmentService.findAllByLevelsToOpen(levelsToOpen);
        return ResponseEntity.ok(attachments);
    }

    @Operation(summary = "Получить все по преимуществам")
    @GetMapping("/byAdvantages")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentByAdvantages(@RequestParam String advantages) {
        List<AttachmentsDto> attachments = attachmentService.findAllByAdvantages(advantages);
        return ResponseEntity.ok(attachments);
    }

    @Operation(summary = "Получить все по недостаткам")
    @GetMapping("/byDisadvantages")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentByDisadvantages(@RequestParam String disadvantages) {
        List<AttachmentsDto> attachments = attachmentService.findAllByDisadvantages(disadvantages);
        return ResponseEntity.ok(attachments);
    }

    @Operation(summary = "Получить все по ограничениям")
    @GetMapping("/bySettingLimits")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentBySettingLimits(@RequestParam String settingLimits) {
        List<AttachmentsDto> attachments = attachmentService.findAllBySettingLimits(settingLimits);
        return ResponseEntity.ok(attachments);
    }
}
