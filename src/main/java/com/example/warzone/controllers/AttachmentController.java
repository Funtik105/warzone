package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.AttachmentNotFoundException;
import com.example.warzone.dtos.AttachmentsDto;
import com.example.warzone.servises.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;
    @GetMapping()
    Iterable<AttachmentsDto> all(){
        return attachmentService.getAll();
    }
    @GetMapping("/{id}")
    AttachmentsDto get(@PathVariable Long id){
        return attachmentService.get(id).orElseThrow(()-> new AttachmentNotFoundException(id));
    }
    @PostMapping()
    AttachmentsDto create(@RequestBody AttachmentsDto attachmentsDto){
        return attachmentService.register(attachmentsDto);
    }
    @PutMapping()
    AttachmentsDto update(@RequestBody AttachmentsDto attachmentsDto){
        return attachmentService.update(attachmentsDto);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        attachmentService.delete(id);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentByName(@RequestParam String name) {
        List<AttachmentsDto> attachments = attachmentService.findAllByName(name);
        return ResponseEntity.ok(attachments);
    }

    @GetMapping("/byWeapons")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentByWeaponsToOpen(@RequestParam String weaponsToOpen) {
        List<AttachmentsDto> attachments = attachmentService.findAllByWeaponsToOpen(weaponsToOpen);
        return ResponseEntity.ok(attachments);
    }
    @GetMapping("/byLevels")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentByLevelsToOpen(@RequestParam short levelsToOpen) {
        List<AttachmentsDto> attachments = attachmentService.findAllByLevelsToOpen(levelsToOpen);
        return ResponseEntity.ok(attachments);
    }
    @GetMapping("/byAdvantages")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentByAdvantages(@RequestParam String advantages) {
        List<AttachmentsDto> attachments = attachmentService.findAllByAdvantages(advantages);
        return ResponseEntity.ok(attachments);
    }
    @GetMapping("/byDisadvantages")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentByDisadvantages(@RequestParam String disadvantages) {
        List<AttachmentsDto> attachments = attachmentService.findAllByDisadvantages(disadvantages);
        return ResponseEntity.ok(attachments);
    }
    @GetMapping("/bySettingLimits")
    public ResponseEntity<List<AttachmentsDto>> getAttachmentBySettingLimits(@RequestParam String settingLimits) {
        List<AttachmentsDto> attachments = attachmentService.findAllBySettingLimits(settingLimits);
        return ResponseEntity.ok(attachments);
    }
}
