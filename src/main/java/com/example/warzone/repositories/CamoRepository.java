package com.example.warzone.repositories;

import com.example.warzone.models.Camo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CamoRepository extends JpaRepository<Camo, Long> {
    @Query("SELECT c FROM Camo c JOIN c.gun g WHERE g.gameRepresents =: gameRepresents")
    List<Camo> findByGameRepresents(String gameRepresents);
    @Query("SELECT c FROM Camo c JOIN c.gun g WHERE g.name =: gunName")
    List<Camo> findByGunName(String gunName);
    @Query("SELECT c FROM Camo c JOIN c.gun g WHERE g.id =: gun_id")
    List<Camo> findCamosByGunId(Long gun_id);
}
