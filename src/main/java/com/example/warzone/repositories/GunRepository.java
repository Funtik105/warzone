package com.example.warzone.repositories;

import com.example.warzone.models.Gun;
import com.example.warzone.models.LoadoutGun;
import com.example.warzone.models.NerfsAndBuffs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GunRepository extends JpaRepository<Gun, Long> {
    List<Gun> findAllByName(String name);

    List<Gun> findAllByCategory(String category);

    List<Gun> findAllByPlatform(String platform);
}
