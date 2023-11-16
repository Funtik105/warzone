package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.NerfsAndBuffsNotFoundException;
import com.example.warzone.dtos.NerfsAndBuffsDto;
import com.example.warzone.servises.NerfsAndBuffsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "NerfsAndBuffs", description = "API для вложений")
@RestController
@RequestMapping("/nerfsandbuffs")
public class NerfsAndBuffsController {
    @Autowired
    private NerfsAndBuffsService nerfsAndBuffsService;
    @Operation(summary = "Получить все")
    @GetMapping()
    Iterable<NerfsAndBuffsDto> all(){return nerfsAndBuffsService.getAll();}
    @Operation(summary = "Получить по id")
    @GetMapping("/{id}")
    NerfsAndBuffsDto get(@PathVariable Long id){
        return nerfsAndBuffsService.get(id).orElseThrow(()-> new NerfsAndBuffsNotFoundException(id));
    }
    @Operation(summary = "Создать")
    @PostMapping()
    NerfsAndBuffsDto create(@RequestBody NerfsAndBuffsDto nerfsAndBuffsDto){
        return nerfsAndBuffsService.register(nerfsAndBuffsDto);
    }
    @Operation(summary = "Обновить")
    @PutMapping()
    NerfsAndBuffsDto update(@RequestBody NerfsAndBuffsDto nerfsAndBuffsDto){
        return nerfsAndBuffsService.update(nerfsAndBuffsDto);
    }
    @Operation(summary = "Удалить")
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        nerfsAndBuffsService.delete(id);
    }
    @Operation(summary = "Получить по дате")
    @GetMapping("/byDate")
    ResponseEntity<List<NerfsAndBuffsDto>> getNerfsAndBuffsByDate(@RequestParam String date){
        List<NerfsAndBuffsDto> nerfsAndBuffs = nerfsAndBuffsService.findAllByDate(date);
        return ResponseEntity.ok(nerfsAndBuffs);
    }
    @Operation(summary = "Получить по имени оружия")
    @GetMapping("/byNameGun")
    ResponseEntity<List<NerfsAndBuffsDto>> getNerfsAndBuffsByNameGun(@RequestParam String nameGun){
        List<NerfsAndBuffsDto> nerfsAndBuffs = nerfsAndBuffsService.findAllByNameGun(nameGun);
        return ResponseEntity.ok(nerfsAndBuffs);
    }
    @Operation(summary = "Получить по статусу")
    @GetMapping("/byStatus")
    ResponseEntity<List<NerfsAndBuffsDto>> getNerfsAndBuffsByStatus(@RequestParam boolean status){
        List<NerfsAndBuffsDto> nerfsAndBuffs = nerfsAndBuffsService.findAllByStatus(status);
        return ResponseEntity.ok(nerfsAndBuffs);
    }
}
