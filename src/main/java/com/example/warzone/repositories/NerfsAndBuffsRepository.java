package com.example.warzone.repositories;

import com.example.warzone.models.NerfsAndBuffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NerfsAndBuffsRepository extends JpaRepository<NerfsAndBuffs, Long> {
    List<NerfsAndBuffs> findAllByDate(String date);

    @Query("SELECT n FROM NerfsAndBuffs n JOIN n.rebalancedGun r JOIN r.gun g WHERE g.name = :nameGun")
    List<NerfsAndBuffs> findAllByNameGun(String nameGun);

}
