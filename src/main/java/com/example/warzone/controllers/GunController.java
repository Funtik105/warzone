package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.GunNotFoundException;
import com.example.warzone.dtos.GunDto;
import com.example.warzone.models.LoadoutGun;
import com.example.warzone.models.NerfsAndBuffs;
import com.example.warzone.servises.GunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guns")
public class GunController {
    @Autowired
    private GunService gunService;
    @GetMapping()
    Iterable<GunDto> all(){
        return gunService.getAll();
    }
    @GetMapping("{id}")
    GunDto get(@PathVariable Long id){
        return gunService.get(id).orElseThrow(()-> new GunNotFoundException(id));
    }
    @PostMapping()
    GunDto create(@RequestBody GunDto gunDto){
        return gunService.register(gunDto);
    }
    @PutMapping()
    GunDto update(@RequestBody GunDto gunDto){
        return gunService.update(gunDto);
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable Long id){
        gunService.delete(id);
    }
    @GetMapping("/byName")
    public ResponseEntity<List<GunDto>> getGunByName(@RequestParam String name) {
        List<GunDto> guns = gunService.findAllByName(name);
        return ResponseEntity.ok(guns);
    }
    @GetMapping("/byCategory")
    public ResponseEntity<List<GunDto>> getGunByCategory(@RequestParam String category) {
        List<GunDto> guns = gunService.findAllByCategory(category);
        return ResponseEntity.ok(guns);
    }
    @GetMapping("/byPlatform")
    public ResponseEntity<List<GunDto>> getGunByPlatform(@RequestParam String platform) {
        List<GunDto> guns = gunService.findAllByPlatform(platform);
        return ResponseEntity.ok(guns);
    }
}
