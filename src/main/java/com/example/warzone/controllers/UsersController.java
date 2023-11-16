package com.example.warzone.controllers;

import com.example.warzone.controllers.exceptions.UsersNotFoundException;
import com.example.warzone.dtos.AttachmentsDto;
import com.example.warzone.dtos.UsersDto;
import com.example.warzone.servises.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "API для вложений")
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Operation(summary = "Получить все")
    @GetMapping()
    Iterable<UsersDto> getAll(){return usersService.getAll();}
    @Operation(summary = "Получить по id")
    @GetMapping("/{id}")
    UsersDto get(@PathVariable Long id){
        return usersService.get(id).orElseThrow(()-> new UsersNotFoundException(id));
    }
    @Operation(summary = "Создать")
    @PostMapping()
    UsersDto create(@RequestBody UsersDto usersDto){
        return usersService.register(usersDto);
    }
    @Operation(summary = "Обновить")
    @PutMapping()
    UsersDto update(@RequestBody UsersDto usersDto){
        return usersService.update(usersDto);
    }
    @Operation(summary = "Удалить")
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        usersService.delete(id);
    }
    @Operation(summary = "Получить по подписчикам")
    @GetMapping("/byFollowers")
    public ResponseEntity<List<UsersDto>> getUserByFollowers(@RequestParam int followers) {
        List<UsersDto> users = usersService.findAllByFollowers(followers);
        return ResponseEntity.ok(users);
    }
    @Operation(summary = "Получить по имени")
    @GetMapping("/byName")
    public ResponseEntity<List<UsersDto>> getUserByName(@RequestParam String name) {
        List<UsersDto> users = usersService.findAllByName(name);
        return ResponseEntity.ok(users);
    }
    @Operation(summary = "Получить по никнейму")
    @GetMapping("/byNickname")
    public ResponseEntity<List<UsersDto>> getUserByNickname(@RequestParam String nickname) {
        List<UsersDto> users = usersService.findAllByNickname(nickname);
        return ResponseEntity.ok(users);
    }
    @Operation(summary = "Получить по почте")
    @GetMapping("/byEmail")
    public ResponseEntity<List<UsersDto>> getUserByEmail(@RequestParam String email) {
        List<UsersDto> users = usersService.findAllByEmail(email);
        return ResponseEntity.ok(users);
    }
    @Operation(summary = "Получить по описанию")
    @GetMapping("/byDescription")
    public ResponseEntity<List<UsersDto>> getUserByDescription(@RequestParam String description) {
        List<UsersDto> users = usersService.findAllByDescription(description);
        return ResponseEntity.ok(users);
    }
    @Operation(summary = "Получить по видимости")
    @GetMapping("/byVisibility")
    public ResponseEntity<List<UsersDto>> getUserByVisibility(@RequestParam String visibility) {
        List<UsersDto> users = usersService.findAllByVisibility(visibility);
        return ResponseEntity.ok(users);
    }
    @Operation(summary = "Получить по аватару")
    @GetMapping("/byAvatar")
    public ResponseEntity<List<UsersDto>> getUserByAvatar(@RequestParam String avatar) {
        List<UsersDto> users = usersService.findAllByAvatar(avatar);
        return ResponseEntity.ok(users);
    }
    @Operation(summary = "Получить по паролю")
    @GetMapping("/byPassword")
    public ResponseEntity<List<UsersDto>> getUserByPassword(@RequestParam String password) {
        List<UsersDto> users = usersService.findAllByPassword(password);
        return ResponseEntity.ok(users);
    }
}
