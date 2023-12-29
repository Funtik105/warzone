package com.example.warzone.repositories;

import com.example.warzone.dtos.GunDto;
import com.example.warzone.models.Gun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GunRepository extends JpaRepository<Gun, Long> {
    List<Gun> findAllByName(String name);

    List<Gun> findAllByCategory(String category);
}
