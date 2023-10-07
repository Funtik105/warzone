package com.example.warzone.servises;

import com.example.warzone.dtos.PerksDto;

import java.util.List;
import java.util.Optional;

public interface PerksService {
    List<PerksDto> getAll();
    Optional<PerksDto> get(Long id);
    PerksDto register(PerksDto perksDto);
    PerksDto update(PerksDto perksDto);
    void delete(Long id);
}
