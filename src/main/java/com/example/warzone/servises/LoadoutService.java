package com.example.warzone.servises;

import com.example.warzone.dtos.LoadoutDto;

import java.util.List;
import java.util.Optional;

public interface LoadoutService{
    List<LoadoutDto> getAll();
    Optional<LoadoutDto> get(Long id);
    LoadoutDto register(LoadoutDto loadoutDto);
    LoadoutDto update(LoadoutDto loadoutDto);
    void delete(Long id);
    List<LoadoutDto> findAllByPerk1(String perk_1);
    List<LoadoutDto> findAllByGun(String gun);
    List<LoadoutDto> findAllByDescription(String description);
    List<LoadoutDto> findAllByDate(String date);
    List<LoadoutDto> findAllByUpdatedAt(String updatedAt);
    List<LoadoutDto> findAllByEnabled(String enabled);

}
