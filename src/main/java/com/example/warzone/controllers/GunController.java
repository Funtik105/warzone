package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.GunNotFoundException;
import com.example.warzone.dtos.GunDto;
import com.example.warzone.servises.GunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
