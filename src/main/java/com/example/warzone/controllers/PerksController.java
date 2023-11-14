package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.PerksNotFoundException;
import com.example.warzone.dtos.PerksDto;
import com.example.warzone.servises.PerksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/byName")
    public ResponseEntity<List<PerksDto>> getPerksByName(@RequestParam String name){
        List<PerksDto> perks = perksService.findAllByName(name);
        return ResponseEntity.ok(perks);
    }
    @GetMapping("/byType")
    public ResponseEntity<List<PerksDto>> getPerksByType(@RequestParam String type){
        List<PerksDto> perks = perksService.findAllByType(type);
        return ResponseEntity.ok(perks);
    }
    @GetMapping("/byDescription")
    public ResponseEntity<List<PerksDto>> getPerksByDescription(@RequestParam String description){
        List<PerksDto> perks = perksService.findAllByDescription(description);
        return ResponseEntity.ok(perks);
    }
}
