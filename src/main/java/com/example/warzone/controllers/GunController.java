package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.GunNotFoundException;
import com.example.warzone.dtos.GunDto;
import com.example.warzone.servises.GunService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gun", description = "API для получения всех оружий игры")
@RestController
@RequestMapping("/gunservice")
public class GunController {
    private GunService gunService;

    @Autowired
    public GunController(GunService gunService) {
        this.gunService = gunService;
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public List<GunDto> getGuns() {
        return gunService.getAll();
    }

    @Operation(summary = "Получить по id")
    @GetMapping("/findById")
    GunDto get(@PathVariable Long id) {
        return gunService.get(id).orElseThrow(() -> new GunNotFoundException(id));
    }

    @Operation(summary = "Добавить новый")
    @PostMapping("/new")
    GunDto create(@RequestBody GunDto gunDto) {
        return gunService.register(gunDto);
    }

    @Operation(summary = "Обновить")
    @PutMapping("/update")
    GunDto update(@RequestBody GunDto gunDto) {
        return gunService.update(gunDto);
    }

    @Operation(summary = "Удалить")
    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        gunService.delete(id);
    }

    @Operation(summary = "Получить по имени")
    @GetMapping("/byName")
    public ResponseEntity<List<GunDto>> getGunByName(@RequestParam String name) {
        List<GunDto> guns = gunService.findAllByName(name);
        return ResponseEntity.ok(guns);
    }

    @Operation(summary = "Получить по категории")
    @GetMapping("/byCategory")
    public ResponseEntity<List<GunDto>> getGunByCategory(@RequestParam String category) {
        List<GunDto> guns = gunService.findAllByCategory(category);
        return ResponseEntity.ok(guns);
    }
}
