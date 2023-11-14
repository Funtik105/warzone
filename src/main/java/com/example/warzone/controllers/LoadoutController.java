package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.LoadoutNotFoundException;
import com.example.warzone.dtos.AttachmentsDto;
import com.example.warzone.dtos.LoadoutDto;
import com.example.warzone.models.LoadoutGun;
import com.example.warzone.models.Perks;
import com.example.warzone.models.Users;
import com.example.warzone.servises.LoadoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loadouts")
public class LoadoutController {
    @Autowired
    private LoadoutService loadoutService;
    @GetMapping()
    Iterable<LoadoutDto> all(){
        return loadoutService.getAll();
    }
    @GetMapping("{id}")
    LoadoutDto get(@PathVariable Long id){
        return loadoutService.get(id).orElseThrow(()-> new LoadoutNotFoundException(id));
    }
    @PostMapping
    LoadoutDto create(@RequestBody LoadoutDto loadoutDto){
        return loadoutService.register(loadoutDto);
    }
    @PutMapping()
    LoadoutDto update(@RequestBody LoadoutDto loadoutDto){
        return loadoutService.update(loadoutDto);
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable Long id){
        loadoutService.delete(id);
    }
    @GetMapping("/byPerk1")
    ResponseEntity<List<LoadoutDto>> getLoadoutByPerk1(@RequestParam String perk1) {
        List<LoadoutDto> loadouts = loadoutService.findAllByPerk1(perk1);
        return ResponseEntity.ok(loadouts);
    }
    @GetMapping("/byGun")
    ResponseEntity<List<LoadoutDto>> getLoadoutByGun(@RequestParam String gun) {
        List<LoadoutDto> loadouts = loadoutService.findAllByGun(gun);
        return ResponseEntity.ok(loadouts);
    }
    @GetMapping("/byDescription")
    ResponseEntity<List<LoadoutDto>> getLoadoutByDescription(@RequestParam String description) {
        List<LoadoutDto> loadouts = loadoutService.findAllByDescription(description);
        return ResponseEntity.ok(loadouts);
    }
    @GetMapping("/byDate")
    ResponseEntity<List<LoadoutDto>> getLoadoutByDate(@RequestParam String date) {
        List<LoadoutDto> loadouts = loadoutService.findAllByDate(date);
        return ResponseEntity.ok(loadouts);
    }
    @GetMapping("/byUpdatedAt")
    ResponseEntity<List<LoadoutDto>> getLoadoutByUpdatedAt(@RequestParam String updatedAt) {
        List<LoadoutDto> loadouts = loadoutService.findAllByUpdatedAt(updatedAt);
        return ResponseEntity.ok(loadouts);
    }
    @GetMapping("/byEnabled")
    ResponseEntity<List<LoadoutDto>> getLoadoutByEnabled(@RequestParam String enabled) {
        List<LoadoutDto> loadouts = loadoutService.findAllByEnabled(enabled);
        return ResponseEntity.ok(loadouts);
    }
}
