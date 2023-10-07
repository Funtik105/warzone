package com.example.warzone.servises;

import com.example.warzone.dtos.NerfsAndBuffsDto;

import java.util.List;
import java.util.Optional;

public interface NerfsAndBuffsService {
    List<NerfsAndBuffsDto> getAll();
    Optional<NerfsAndBuffsDto> get(Long id);
    NerfsAndBuffsDto register(NerfsAndBuffsDto nerfsAndBuffsDto);
    NerfsAndBuffsDto update(NerfsAndBuffsDto nerfsAndBuffsDto);
    void delete(Long id);
}
