package com.example.warzone.repositories;

import com.example.warzone.models.Loadout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadoutRepository extends JpaRepository<Loadout, Long>{
    List<Loadout> findAllByPerks1(String perks1);

    List<Loadout> findAllByGuns(String guns);

    List<Loadout> findAllByDescription(String description);

    List<Loadout> findAllByDate(String date);

    List<Loadout> findAllByUpdatedAt(String updatedAt);

    List<Loadout> findAllByEnabled(String enabled);
}
