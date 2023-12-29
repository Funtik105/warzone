package com.example.warzone.servises;

import com.example.warzone.models.Gun;

import java.util.List;
import java.util.Optional;

public interface GunService {
    List<Gun> getAll();

    Optional<Gun> get(Long id);

    Gun register(Gun gun);

    Optional<Gun> editByName(String name, Gun updatedGun);

    Optional<Gun> findByName(String name);

    Optional<Gun> findByCategory(String category);

    void delete(Long id);
}
