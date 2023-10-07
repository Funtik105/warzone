package com.example.warzone.servises;

import com.example.warzone.dtos.LoadoutGunDto;

import java.util.List;
import java.util.Optional;

public interface LoadoutGunService {
    List<LoadoutGunDto> getAll();
    Optional<LoadoutGunDto> get(Long id);
    LoadoutGunDto register(LoadoutGunDto loadoutGunDto);
    LoadoutGunDto update(LoadoutGunDto loadoutGunDto);
    void delete(Long id);
 }
