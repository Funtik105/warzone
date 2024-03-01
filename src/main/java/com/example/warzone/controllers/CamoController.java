package com.example.warzone.controllers;

import com.example.warzone.dtos.response.FindResponse;
import com.example.warzone.dtos.response.ResponseApi;
import com.example.warzone.dtos.CamoDto;
import com.example.warzone.servises.CamoService;
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
@RequestMapping("/camo")
public class CamoController {
    private CamoService camoService;

    @Autowired
    public CamoController(CamoService camoService) {
        this.camoService = camoService;
    }

    @PostMapping("/new")
    @Operation(summary = "Добавить новый камуфляж")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Новый камуфляж успешно создано",
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
    public ResponseEntity<ResponseApi> createCamo(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    description = "Новый камуфляж",
                                    value = "{\"name\": \"Kastov 545\", \"category\": \"Assault Rifles\", \"gameRepresents\": \"MW2\"}" // TODO: Поправить свагер
                            )
                    )
            )

            @RequestBody CamoDto camo) {
        CamoDto savedCamo = camoService.register(camo);

        ResponseApi response = new ResponseApi(savedCamo.getId(), new ArrayList<>());
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
                    @ApiResponse(responseCode = "404", description = "Камуфляж не найден")
            }
    )
    public ResponseEntity<?> find(
            @RequestParam(required = false) Long gun_id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Boolean status) {

        if (gun_id != null) {
            List<CamoDto> camos = camoService.findCamosByGunId(gun_id);
            return buildFindCamosResponse(camos);
        } else
        if (title != null) {
            List<CamoDto> camos = camoService.findCamosByTitle(title);
            return buildFindCamosResponse(camos);
        } else if (status != null) {
            List<CamoDto> camos = camoService.findCamosByStatus(status);
            return buildFindCamosResponse(camos);
        } else {
            // If no parameters are passed, return a list of all weapons
            List<CamoDto> camos = camoService.getAll();
            return buildFindCamosResponse(camos);
        }
    }

    private ResponseEntity<FindResponse<CamoDto>> buildFindCamosResponse(List<CamoDto> camos) {
        FindResponse response = new FindResponse();
        response.setTotalCount(camos.size());
        response.setBody(camos);
        response.setErrors(new ArrayList<>());
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete")
    @Operation(summary = "Удалить по id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Камуфляж успешно обновлено"),
                    @ApiResponse(responseCode = "400", description = "Неверный запрос"),
                    @ApiResponse(responseCode = "403", description = "Доступ запрещён"),
                    @ApiResponse(responseCode = "404", description = "Камуфляж не найден")
            }
    )
    public ResponseEntity<ResponseApi> delete(
            @Parameter(description = "Имя камуфляжа", example = "Interstellar")
            @RequestParam Long id
    ) {
        try {
            camoService.delete(id);
            // Успешное выполнение
            return ResponseEntity.ok(new ResponseApi(true, new ArrayList<>()));
        } catch (Exception e) {
            // Обработка ошибки
            return new ResponseEntity<>(new ResponseApi(false, Collections.singletonList(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
