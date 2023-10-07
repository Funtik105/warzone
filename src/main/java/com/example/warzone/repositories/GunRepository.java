package com.example.warzone.repositories;

import com.example.warzone.models.Gun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GunRepository extends JpaRepository<Gun,Long> {
}
