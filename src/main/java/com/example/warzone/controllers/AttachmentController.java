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
}
