package com.example.warzone.repositories;

import com.example.warzone.models.Loadout;
import com.example.warzone.models.LoadoutGun;
import com.example.warzone.models.Perks;
import com.example.warzone.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadoutRepository extends JpaRepository<Loadout,Long> {
    List<Loadout> findAllByPerks1(String perks1);
    List<Loadout> findAllByGuns(String guns);
    List<Loadout> findAllByDescription(String description);
    List<Loadout> findAllByDate(String date);
    List<Loadout> findAllByUpdatedAt(String updatedAt);
    List<Loadout> findAllByEnabled(String enabled);

}
