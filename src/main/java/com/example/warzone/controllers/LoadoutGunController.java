package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.LoadoutGunNotFoundException;
import com.example.warzone.dtos.LoadoutGunDto;
import com.example.warzone.servises.LoadoutGunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loadoutguns")
public class LoadoutGunController {
    @Autowired
    private LoadoutGunService loadoutGunService;
    @GetMapping()
    Iterable<LoadoutGunDto> all(){return loadoutGunService.getAll();}
    @GetMapping("{id}")
    LoadoutGunDto get(@PathVariable Long id){
        return loadoutGunService.get(id).orElseThrow(()-> new LoadoutGunNotFoundException(id));
    }
    @PostMapping()
    LoadoutGunDto create(@RequestBody LoadoutGunDto loadoutGunDto){
        return loadoutGunService.register(loadoutGunDto);
    }
    @PutMapping()
    LoadoutGunDto update(@RequestBody LoadoutGunDto loadoutGunDto){
        return loadoutGunService.update(loadoutGunDto);
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable Long id){
        loadoutGunService.delete(id);
    }
}
