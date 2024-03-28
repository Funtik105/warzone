package com.example.warzone.controllers;

import com.example.warzone.dtos.RebalancedGunDto;
import com.example.warzone.dtos.response.FindResponse;
import com.example.warzone.dtos.response.ResponseApi;
import com.example.warzone.servises.RebalancedGunService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rebalancedGun")
public class RebalancedGunController {
    private RebalancedGunService rebalancedGunService;
    public RebalancedGunController(RebalancedGunService rebalancedGunService) {
        this.rebalancedGunService = rebalancedGunService;
    }

    @PostMapping("/new")
    @Operation(summary = "Добавить новое перебалансированное оружие")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Новое перебалансированое оружие успешно создано",
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
    public ResponseEntity<ResponseApi> createRebalancedGun(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    description = "Новое перебалансирование оружие",
                                    value = "{\"name\": \"Kastov 545\", \"category\": \"Assault Rifles\", \"gameRepresents\": \"MW2\"}" // TODO: Поправить свагер
                            )
                    )
            )
            @RequestBody RebalancedGunDto rebalancedGun) {
            RebalancedGunDto savedRebalancedGun = rebalancedGunService.register(rebalancedGun);

            ResponseApi response = new ResponseApi(savedRebalancedGun.getId(), new ArrayList<>());
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
                    @ApiResponse(responseCode = "404", description = "Перебалансирование оружие не найдено")
            }
    )
    public ResponseEntity<?> find() {
        List<RebalancedGunDto> rebalancedGun = rebalancedGunService.getAll();
        return buildFindRebalancedGunsResponse(rebalancedGun);
    }

    private ResponseEntity<FindResponse<RebalancedGunDto>> buildFindRebalancedGunsResponse(List<RebalancedGunDto> rebalancedGuns) {
        FindResponse response = new FindResponse();
        response.setTotalCount(rebalancedGuns.size());
        response.setBody(rebalancedGuns);
        response.setErrors(new ArrayList<>());
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete")
    @Operation(summary = "Удалить по id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Перебалансирование оружие успешно обновлено"),
                    @ApiResponse(responseCode = "400", description = "Неверный запрос"),
                    @ApiResponse(responseCode = "403", description = "Доступ запрещён"),
                    @ApiResponse(responseCode = "404", description = "Перебалансирование оружие не найдено")
            }
    )
    public ResponseEntity<ResponseApi> delete(
            @Parameter(description = "Имя перебалансированого оружия", example = "Interstellar")
            @RequestParam Long id
    ) {
        try {
            rebalancedGunService.delete(id);
            // Успешное выполнение
            return ResponseEntity.ok(new ResponseApi(true, new ArrayList<>()));
        } catch (Exception e) {
            // Обработка ошибки
            return new ResponseEntity<>(new ResponseApi(false, Collections.singletonList(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
