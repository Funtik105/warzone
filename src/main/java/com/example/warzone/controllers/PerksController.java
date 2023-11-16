package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.PerksNotFoundException;
import com.example.warzone.dtos.PerksDto;
import com.example.warzone.servises.PerksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Perks", description = "API для вложений")
@RestController
@RequestMapping("/perks")
public class PerksController {
    @Autowired
    private PerksService perksService;
    @Operation(summary = "Получить все")
    @GetMapping()
    Iterable<PerksDto> getAll(){
        return perksService.getAll();
    }
    @Operation(summary = "Получить по id")
    @GetMapping("/{id}")
    PerksDto get(@PathVariable Long id){
        return perksService.get(id).orElseThrow(()-> new PerksNotFoundException(id));
    }
    @Operation(summary = "Создать")
    @PostMapping()
    PerksDto create(@RequestBody PerksDto perksDto){
        return perksService.register(perksDto);
    }
    @Operation(summary = "Обновить")
    @PutMapping()
    PerksDto update(@RequestBody PerksDto perksDto){return  perksService.update(perksDto);}
    @Operation(summary = "Удалить")
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        perksService.delete(id);
    }
    @Operation(summary = "Получить по имени")
    @GetMapping("/byName")
    public ResponseEntity<List<PerksDto>> getPerksByName(@RequestParam String name){
        List<PerksDto> perks = perksService.findAllByName(name);
        return ResponseEntity.ok(perks);
    }
    @Operation(summary = "Получить по типу")
    @GetMapping("/byType")
    public ResponseEntity<List<PerksDto>> getPerksByType(@RequestParam String type){
        List<PerksDto> perks = perksService.findAllByType(type);
        return ResponseEntity.ok(perks);
    }
    @Operation(summary = "Получить по описанию")
    @GetMapping("/byDescription")
    public ResponseEntity<List<PerksDto>> getPerksByDescription(@RequestParam String description){
        List<PerksDto> perks = perksService.findAllByDescription(description);
        return ResponseEntity.ok(perks);
    }
}
