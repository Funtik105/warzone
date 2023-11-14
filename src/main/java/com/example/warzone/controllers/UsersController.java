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
    @GetMapping("/byName")
    public ResponseEntity<List<UsersDto>> getUserByName(@RequestParam String name) {
        List<UsersDto> users = usersService.findAllByName(name);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/byNickname")
    public ResponseEntity<List<UsersDto>> getUserByNickname(@RequestParam String nickname) {
        List<UsersDto> users = usersService.findAllByNickname(nickname);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/byEmail")
    public ResponseEntity<List<UsersDto>> getUserByEmail(@RequestParam String email) {
        List<UsersDto> users = usersService.findAllByEmail(email);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/byDescription")
    public ResponseEntity<List<UsersDto>> getUserByDescription(@RequestParam String description) {
        List<UsersDto> users = usersService.findAllByDescription(description);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/byVisibility")
    public ResponseEntity<List<UsersDto>> getUserByVisibility(@RequestParam String visibility) {
        List<UsersDto> users = usersService.findAllByVisibility(visibility);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/byAvatar")
    public ResponseEntity<List<UsersDto>> getUserByAvatar(@RequestParam String avatar) {
        List<UsersDto> users = usersService.findAllByAvatar(avatar);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/byPassword")
    public ResponseEntity<List<UsersDto>> getUserByPassword(@RequestParam String password) {
        List<UsersDto> users = usersService.findAllByPassword(password);
        return ResponseEntity.ok(users);
    }
}
