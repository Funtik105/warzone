package com.example.warzone.repositories;

import com.example.warzone.models.Attachments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachments, Long> {
    List<Attachments> findAllByName(String name);

    List<Attachments> findAllByWeaponsToOpen(String weaponsToOpen);

    List<Attachments> findAllByLevelsToOpen(short levelsToOpen);

    List<Attachments> findAllByAdvantages(String advantages);

    List<Attachments> findAllByDisadvantages(String disadvantages);

    List<Attachments> findAllBySettingLimits(String settingLimits);

}
