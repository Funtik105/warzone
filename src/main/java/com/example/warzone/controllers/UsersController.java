package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.UsersNotFoundException;
import com.example.warzone.dtos.AttachmentsDto;
import com.example.warzone.dtos.UsersDto;
import com.example.warzone.servises.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping()
    Iterable<UsersDto> getAll(){return usersService.getAll();}
    @GetMapping("/{id}")
    UsersDto get(@PathVariable Long id){
        return usersService.get(id).orElseThrow(()-> new UsersNotFoundException(id));
    }
    @PostMapping()
    UsersDto create(@RequestBody UsersDto usersDto){
        return usersService.register(usersDto);
    }
    @PutMapping()
    UsersDto update(@RequestBody UsersDto usersDto){
        return usersService.update(usersDto);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        usersService.delete(id);
    }

    @GetMapping("/byFollowers")
    public ResponseEntity<List<UsersDto>> getUserByFollowers(@RequestParam int followers) {
        List<UsersDto> users = usersService.findAllByFollowers(followers);
        return ResponseEntity.ok(users);
    }
}
