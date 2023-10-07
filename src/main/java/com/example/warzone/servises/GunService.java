package com.example.warzone.servises;

import com.example.warzone.dtos.GunDto;

import java.util.List;
import java.util.Optional;

public interface GunService {
    List<GunDto> getAll();
    Optional<GunDto> get(Long id);
    GunDto register(GunDto gunDto);
    GunDto update(GunDto gunDto);
    void delete(Long id);
}
