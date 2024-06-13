package com.example.warzone.controllers;

import com.example.warzone.dtos.AttachmentsDto;
import com.example.warzone.dtos.response.FindResponse;
import com.example.warzone.dtos.response.ResponseApi;
import com.example.warzone.servises.AttachmentService;
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

@Tag(name = "Attachments", description = "API для вложений")
@RestController
@RequestMapping("/attachments")
public class AttachmentController{
    private AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
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
    public ResponseEntity<ResponseApi> createAttachment(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    description = "Новое перебалансирование оружие",
                                    value = "{\"name\": \"Kastov 545\", \"category\": \"Assault Rifles\", \"gameRepresents\": \"MW2\"}" // TODO: Поправить свагер
                            )
                    )
            )
            @RequestBody AttachmentsDto attachment) {
        AttachmentsDto savedAttachment = attachmentService.register(attachment);

        ResponseApi response = new ResponseApi(savedAttachment.getId(), new ArrayList<>());
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
    public ResponseEntity<?> find(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String weaponsToOpen,
            @RequestParam(required = false) Integer levelsToOpen) {

        if (name != null) {
            List<AttachmentsDto> attachment = attachmentService.findAllByName(name);
            return buildFindAttachmentResponse(attachment);
        } else if (weaponsToOpen != null) {
            List<AttachmentsDto> attachment = attachmentService.findAllByWeaponsToOpen(weaponsToOpen);
            return buildFindAttachmentResponse(attachment);
        } else if (levelsToOpen != null) {
            List<AttachmentsDto> attachment = attachmentService.findAllByLevelsToOpen(levelsToOpen);
            return buildFindAttachmentResponse(attachment);
        } else {
            List<AttachmentsDto> attachment = attachmentService.getAll();
            return buildFindAttachmentResponse(attachment);
        }
    }

    private ResponseEntity<FindResponse<AttachmentsDto>> buildFindAttachmentResponse(List<AttachmentsDto> attachments) {
        FindResponse response = new FindResponse();
        response.setTotalCount(attachments.size());
        response.setBody(attachments);
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
            attachmentService.delete(id);
            // Успешное выполнение
            return ResponseEntity.ok(new ResponseApi(true, new ArrayList<>()));
        } catch (Exception e) {
            // Обработка ошибки
            return new ResponseEntity<>(new ResponseApi(false, Collections.singletonList(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
