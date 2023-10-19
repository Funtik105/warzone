package com.example.warzone.repositories;

import com.example.warzone.models.Loadout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadoutRepository extends JpaRepository<Loadout,Long> {
//    List<Loadout> findAllByName(String name);
}
