package com.example.warzone.repositories;

import com.example.warzone.models.NerfsAndBuffs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NerfsAndBuffsRepository extends JpaRepository<NerfsAndBuffs, Long> {
    List<NerfsAndBuffs> findAllByDate(String date);

    List<NerfsAndBuffs> findAllByNameGun(String nameGun);

    List<NerfsAndBuffs> findAllByStatus(boolean status);
}
