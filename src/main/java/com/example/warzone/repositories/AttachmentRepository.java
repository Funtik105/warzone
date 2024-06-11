package com.example.warzone.repositories;

import com.example.warzone.models.Attachments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachments, Long> {
    List<Attachments> findAllByName(String name);
    @Query("SELECT a FROM Attachments a JOIN a.gun g WHERE g.name= :weaponsToOpen")
    List<Attachments> findAllByWeaponsToOpen(String weaponsToOpen);

    List<Attachments> findAllByLevelsToOpen(Integer levelsToOpen);
}
