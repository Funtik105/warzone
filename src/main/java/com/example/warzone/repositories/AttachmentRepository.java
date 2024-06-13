package com.example.warzone.repositories;

import com.example.warzone.models.Attachments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * A repository for the Attachments entity that inherits JpaRepository
 * and provides additional methods for searching for attachments.
 */
public interface AttachmentRepository extends JpaRepository<Attachments, Long> {

    /**
     * Finds all attachments with the specified name.
     *
     * @param name attachment name
     * @return list of attachments with the specified name
     */
    List<Attachments> findAllByName(String name);

    /**
     * Finds all attachments that can be opened for the specified weapon.
     * Performs a database query using JPQL.
     *
     * @param weaponsToOpen name of the weapon for which you want to find attachments
     * @return list of attachments that can be opened for the specified weapon
     */
    @Query("SELECT a FROM Attachments a JOIN a.gun g WHERE g.name= :weaponsToOpen")
    List<Attachments> findAllByWeaponsToOpen(String weaponsToOpen);

    /**
     * Finds all attachments that can be opened at the specified level.
     *
     * @param levelsToOpen level for which you need to find attachments
     * @return список attachments that can be opened at the specified level
     */
    List<Attachments> findAllByLevelsToOpen(Integer levelsToOpen);
}
