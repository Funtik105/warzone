package com.example.warzone.servises;

import com.example.warzone.dtos.gunservice.GunDto;
import com.example.warzone.models.Gun;

import java.util.List;
import java.util.Optional;

public interface GunService {
    List<GunDto> getAll();

    Optional<GunDto> get(Long id);

    Gun register(Gun gun);

    Optional<Gun> editByName(String name, Gun updatedGun);

    Optional<GunDto> findByName(String name);

    List<GunDto> findByCategory(String category);

    void delete(Long id);
}
