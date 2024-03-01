package com.example.warzone.servises;

import com.example.warzone.dtos.gunservice.GunDto;
import com.example.warzone.models.Gun;

import java.util.List;
import java.util.Optional;

public interface GunService {
    List<GunDto> getAll();

    Optional<GunDto> get(Long id);

    List<GunDto> findByName(String name);

    List<GunDto> findByCategory(String category);

    List<GunDto> findByGameRepresents(String gameRepresents);

    GunDto register(GunDto gun);

    Optional<GunDto> editByName(String name, GunDto updatedGun);

    void delete(Long id);
}
