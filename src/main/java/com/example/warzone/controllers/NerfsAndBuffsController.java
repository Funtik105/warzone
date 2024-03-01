package com.example.warzone.controllers;

import com.example.warzone.dtos.NerfsAndBuffsDto;
import com.example.warzone.dtos.response.FindResponse;
import com.example.warzone.dtos.response.ResponseApi;
import com.example.warzone.servises.NerfsAndBuffsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/nerfsAndBuffs")
public class NerfsAndBuffsController {
    private NerfsAndBuffsService nerfsAndBuffsService;

    @Autowired
    public NerfsAndBuffsController(NerfsAndBuffsService nerfsAndBuffsService) {
        this.nerfsAndBuffsService = nerfsAndBuffsService;
    }

    @PostMapping("/new")
    @Operation(summary = "Добавить новый нерф или бафф")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Новый нерф или бафф успешно создано",
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
    public ResponseEntity<ResponseApi> createNerfsAndBuffs(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    description = "Новый нерф или бафф",
                                    value = "{\"name\": \"Kastov 545\", \"category\": \"Assault Rifles\", \"gameRepresents\": \"MW2\"}" // TODO: Поправить свагер
                            )
                    )
            )

            @RequestBody NerfsAndBuffsDto nerfsAndBuffs) {
        NerfsAndBuffsDto savedNerfsAndBuffs = nerfsAndBuffsService.register(nerfsAndBuffs);

        ResponseApi response = new ResponseApi(savedNerfsAndBuffs.getId(), new ArrayList<>());
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
                                            value = "{ \"totalCount\": 1, \"body\": [{ \"id\": 1, \"name\": \"Kastov 545\", \"category\": \"Assault Rifles\", \"gameRepresents\": \"MW2\" }], \"errors\": [] }" //TODO: Поправить свагер
                                    )
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Неверный запрос"),
                    @ApiResponse(responseCode = "404", description = "Нерф или бафф не найден")
            }
    )
    public ResponseEntity<?> find(
            @RequestParam(required = false) String nameGun,
            @RequestParam(required = false) Boolean status) {

        if (nameGun != null) {
            List<NerfsAndBuffsDto> nerfsAndBuffs = nerfsAndBuffsService.findAllByNameGun(nameGun);
            return buildFindNerfsAndBuffsResponse(nerfsAndBuffs);
        } else if (status != null) {
            List<NerfsAndBuffsDto> nerfsAndBuffs = nerfsAndBuffsService.findAllByStatus(status);
            return buildFindNerfsAndBuffsResponse(nerfsAndBuffs);
        } else {
            // If no parameters are passed, return a list of all weapons
            List<NerfsAndBuffsDto> nerfsAndBuffs = nerfsAndBuffsService.getAll();
            return buildFindNerfsAndBuffsResponse(nerfsAndBuffs);
        }
    }

    private ResponseEntity<FindResponse<NerfsAndBuffsDto>> buildFindNerfsAndBuffsResponse(List<NerfsAndBuffsDto> nerfsAndBuffs) {
        FindResponse response = new FindResponse();
        response.setTotalCount(nerfsAndBuffs.size());
        response.setBody(nerfsAndBuffs);
        response.setErrors(new ArrayList<>());
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete")
    @Operation(summary = "Удалить по id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Нерф или бафф успешно обновлено"),
                    @ApiResponse(responseCode = "400", description = "Неверный запрос"),
                    @ApiResponse(responseCode = "403", description = "Доступ запрещён"),
                    @ApiResponse(responseCode = "404", description = "Нерф или бафф не найден")
            }
    )
    public ResponseEntity<ResponseApi> delete(
            @Parameter(description = "Имя нерфа или бафа", example = "Нерф Kastov545")
            @RequestParam Long id
    ) {
        try {
            nerfsAndBuffsService.delete(id);
            // Успешное выполнение
            return ResponseEntity.ok(new ResponseApi(true, new ArrayList<>()));
        } catch (Exception e) {
            // Обработка ошибки
            return new ResponseEntity<>(new ResponseApi(false, Collections.singletonList(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
