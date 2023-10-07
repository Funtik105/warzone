package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.NerfsAndBuffsNotFoundException;
import com.example.warzone.dtos.NerfsAndBuffsDto;
import com.example.warzone.servises.NerfsAndBuffsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/nerfsandbuffs")
public class NerfsAndBuffsController {
    @Autowired
    private NerfsAndBuffsService nerfsAndBuffsService;
    @GetMapping()
    Iterable<NerfsAndBuffsDto> all(){return nerfsAndBuffsService.getAll();}
    @GetMapping("/{id}")
    NerfsAndBuffsDto get(@PathVariable Long id){
        return nerfsAndBuffsService.get(id).orElseThrow(()-> new NerfsAndBuffsNotFoundException(id));
    }
    @PostMapping()
    NerfsAndBuffsDto create(@RequestBody NerfsAndBuffsDto nerfsAndBuffsDto){
        return nerfsAndBuffsService.register(nerfsAndBuffsDto);
    }
    @PutMapping()
    NerfsAndBuffsDto update(@RequestBody NerfsAndBuffsDto nerfsAndBuffsDto){
        return nerfsAndBuffsService.update(nerfsAndBuffsDto);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        nerfsAndBuffsService.delete(id);
    }
}
