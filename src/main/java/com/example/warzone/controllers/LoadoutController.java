package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.LoadoutNotFoundException;
import com.example.warzone.dtos.LoadoutDto;
import com.example.warzone.servises.LoadoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
