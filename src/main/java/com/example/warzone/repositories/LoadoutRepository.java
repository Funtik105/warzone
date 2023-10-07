package com.example.warzone.repositories;

import com.example.warzone.models.Loadout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadoutRepository extends JpaRepository<Loadout,Long> {
}
