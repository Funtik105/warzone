package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.PerksNotFoundException;
import com.example.warzone.dtos.PerksDto;
import com.example.warzone.servises.PerksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perks")
public class PerksController {
    @Autowired
    private PerksService perksService;
    @GetMapping()
    Iterable<PerksDto> getAll(){
        return perksService.getAll();
    }
    @GetMapping("/{id}")
    PerksDto get(@PathVariable Long id){
        return perksService.get(id).orElseThrow(()-> new PerksNotFoundException(id));
    }
    @PostMapping()
    PerksDto create(@RequestBody PerksDto perksDto){
        return perksService.register(perksDto);
    }
    @PutMapping()
    PerksDto update(@RequestBody PerksDto perksDto){return  perksService.update(perksDto);}
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        perksService.delete(id);
    }
}
