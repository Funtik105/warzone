package com.example.warzone.repositories;

import com.example.warzone.models.Gun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GunRepository extends JpaRepository<Gun, Long> {
    Optional<Gun> findByName(String name);

    Optional<Gun> findByCategory(String category);
}
