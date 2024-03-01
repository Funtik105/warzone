package com.example.warzone.controllers;

import com.example.warzone.dtos.response.FindResponse;
import com.example.warzone.dtos.response.ResponseApi;
import com.example.warzone.dtos.GunDto;
import com.example.warzone.servises.GunService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Tag(name = "Gun", description = "API для получения всех оружий игры")
@RestController
@RequestMapping("/gunservice")
public class GunController{
    private final GunService gunService;

    @Autowired
    public GunController(GunService gunService) {
        this.gunService = gunService;
    }

    @PostMapping("/new")
    @Operation(summary = "Добавить новое оружие")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Новое оружие успешно создано",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            value = "{ \"body\": 1, \"errors\": \"[]\" }"
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Неверный запрос"),
                    @ApiResponse(responseCode = "403", description = "Доступ запрещен")
            }
    )
    public ResponseEntity<ResponseApi> createGun(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    description = "Новое оружие",
                                    value = "{\"name\": \"Kastov 545\", \"category\": \"Assault Rifles\", \"gameRepresents\": \"MW2\"}"
                            )
                    )
            )

            @RequestBody GunDto gun) {
        GunDto savedGun = gunService.register(gun);

        ResponseApi response = new ResponseApi(savedGun.getId(), new ArrayList<>());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/find")
    @Operation(summary = "Получить все или по опредленному параметру")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Операция успешно выполнена",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            value = "{ \"totalCount\": 1, \"body\": [{ \"id\": 1, \"name\": \"Kastov 545\", \"category\": \"Assault Rifles\", \"gameRepresents\": \"MW2\" }], \"errors\": [] }"
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Неверный запрос"),
                    @ApiResponse(responseCode = "404", description = "Оружие не найдено")
            }
    )
    public ResponseEntity<?> find(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String gameRepresents) {

        if (id != null) {
            return gunService.get(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } else if (name != null) {
            List<GunDto> guns = gunService.findByName(name);
            return buildFindGunsResponse(guns);
        } else if (category != null) {
            List<GunDto> guns = gunService.findByCategory(category);
            return buildFindGunsResponse(guns);
        } else if (gameRepresents != null) {
            List<GunDto> guns = gunService.findByGameRepresents(gameRepresents);
            return buildFindGunsResponse(guns);
        } else {
            // If no parameters are passed, return a list of all weapons
            List<GunDto> guns = gunService.getAll();
            return buildFindGunsResponse(guns);
        }
    }

    private ResponseEntity<FindResponse<GunDto>> buildFindGunsResponse(List<GunDto> guns) {
        FindResponse response = new FindResponse();
        response.setTotalCount(guns.size());
        response.setBody(guns);
        response.setErrors(new ArrayList<>());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/edit")
    @Operation(summary = "Обновить существующий по имени")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Оружие успешно обновлено"),
                    @ApiResponse(responseCode = "400", description = "Неверный запрос"),
                    @ApiResponse(responseCode = "403", description = "Доступ запрещён"),
                    @ApiResponse(responseCode = "404", description = "Оружие не найдено")
            }
    )
    public ResponseEntity<ResponseApi> update(
            @Parameter(description = "Имя оружия", example = "Kastov 545")
            @RequestParam String name,
            @RequestBody GunDto gun
    ) {
        return gunService.editByName(name, gun)
                .map(savedGun -> new ResponseEntity<>(new ResponseApi(savedGun.getId(), new ArrayList<>()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new ResponseApi(null, Collections.singletonList("Gun not found")), HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Удалить по id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Оружие успешно обновлено"),
                    @ApiResponse(responseCode = "400", description = "Неверный запрос"),
                    @ApiResponse(responseCode = "403", description = "Доступ запрещён"),
                    @ApiResponse(responseCode = "404", description = "Оружие не найдено")
            }
    )
    public ResponseEntity<ResponseApi> delete(
            @Parameter(description = "Имя оружия", example = "Kastov 545")
            @RequestParam Long id
    ) {
        try {
            gunService.delete(id);
            // Успешное выполнение
            return ResponseEntity.ok(new ResponseApi(true, new ArrayList<>()));
        } catch (Exception e) {
            // Обработка ошибки
            return new ResponseEntity<>(new ResponseApi(false, Collections.singletonList(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
