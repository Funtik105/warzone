package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.MetaListNotFoundException;
import com.example.warzone.dtos.MetaListDto;
import com.example.warzone.servises.MetaListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metalists")
public class MetaListController {
    @Autowired
    private MetaListService metaListService;
    @GetMapping()
    Iterable<MetaListDto> all(){return  metaListService.getAlL();}
    @GetMapping("/{id}")
    MetaListDto get(@PathVariable Long id){
        return  metaListService.get(id).orElseThrow(()-> new MetaListNotFoundException(id));
    }
    @PostMapping()
    MetaListDto create(@RequestBody MetaListDto metaListDto){
        return metaListService.register(metaListDto);
    }
    @PutMapping()
    MetaListDto update(@RequestBody MetaListDto metaListDto){
        return metaListService.update(metaListDto);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        metaListService.delete(id);
    }
}
