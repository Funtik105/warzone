package com.example.warzone.repositories;

import com.example.warzone.models.Perks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerksRepository extends JpaRepository<Perks,Long> {
    List<Perks> findAllByName(String name);
    List<Perks> findAllByType(String type);
    List<Perks> findAllByDescription(String description);
}
