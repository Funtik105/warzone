package com.example.warzone.controllers;

import com.example.warzone.dtos.gunservice.FindGunsResponse;
import com.example.warzone.dtos.gunservice.GunDto;
import com.example.warzone.models.Gun;
import com.example.warzone.servises.GunService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Gun", description = "API для получения всех оружий игры")
@RestController
@RequestMapping("/gunservice")
public class GunController {
    private final GunService gunService;

    @Autowired
    public GunController(GunService gunService) {
        this.gunService = gunService;
    }

    @Operation(summary = "Получить все")
    @GetMapping("/all")
    public ResponseEntity<FindGunsResponse> findAllGuns() {
        List<GunDto> guns = gunService.getAll(); // Получение списка оружия
        FindGunsResponse response = new FindGunsResponse();
        response.setTotalCount(guns.size());
        response.setBody(guns);
        response.setErrors(new ArrayList<>()); // Пустой список ошибок

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Получить по id")
    @GetMapping("/findById")
    public ResponseEntity<GunDto> get(@RequestParam Long id) {
//        List<Gun> guns = gunService.get(id);
////                .map(ResponseEntity::ok)
////                .orElseGet(() -> ResponseEntity.notFound().build());
//        FindGunsResponse response = new FindGunsResponse();
//        response.setTotalCount(guns.size());
//        response.setBody(guns);
//        response.setErrors(new ArrayList<>());
//
//        return ResponseEntity.ok(response);

        return gunService.get(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Получить по имени")
    @GetMapping("/findByName")
    public ResponseEntity<GunDto> getGunByName(@RequestParam String name) {
        return gunService.findByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Получить по категории")
    @GetMapping("/findByCategory")
    public ResponseEntity<GunDto> getGunByCategory(@RequestParam String category) {
        return gunService.findByCategory(category)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Добавить новый")
    @PostMapping("/new")
    public ResponseEntity<Gun> createGun(@RequestBody Gun gun) {
        Gun savedGun = gunService.register(gun);
        return new ResponseEntity<>(savedGun, HttpStatus.CREATED);
    }

    @Operation(summary = "Обновить существующий по имени")
    @PutMapping("/editByName")
    public ResponseEntity<Gun> update(@RequestParam String name, @RequestBody Gun gun) {
        return gunService.editByName(name, gun)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Удалить по id")
    @DeleteMapping("/deleteById")
    void delete(@RequestParam Long id) {
        gunService.delete(id);
    }
}
