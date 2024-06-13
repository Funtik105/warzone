package com.example.warzone.servises;

import com.example.warzone.dtos.AttachmentsDto;

import java.util.List;
import java.util.Optional;

/**
 * Service for working with attachments.
 */
public interface AttachmentService {

    /**
     * Returns a list of all attachments.
     *
     * @return list of all attachments
     */
    List<AttachmentsDto> getAll();

    /**
     * Returns the attachment with the specified ID.
     *
     * @param id attachment ID
     * @return Optional, containing the attachment, or empty Optional if the attachment is not found
     */
    Optional<AttachmentsDto> get(Long id);

    /**
     * Registers a new attachment.
     *
     * @param attachmentsDto information about the new attachment
     * @return created attachment
     */
    AttachmentsDto register(AttachmentsDto attachmentsDto);

    /**
     * Updates an existing attachment.
     *
     * @param attachmentsDto updated attachment details
     * @return updated attachment
     */
    AttachmentsDto update(AttachmentsDto attachmentsDto);

    /**
     * Finds all attachments with the specified name.
     *
     * @param name attachment name
     * @return list of attachments with the specified name
     */
    List<AttachmentsDto> findAllByName(String name);

    /**
     * Находит все вложения, которые могут быть открыты для указанного оружия.
     *
     * @param weaponsToOpen имя оружия
     * @return список вложений, которые могут быть открыты для указанного оружия
     */
    List<AttachmentsDto> findAllByWeaponsToOpen(String weaponsToOpen);

    /**
     * Finds all attachments that can be opened at the specified level.
     *
     * @param levelsToOpen opening level
     * @return list of attachments that can be opened at a specified level
     */
    List<AttachmentsDto> findAllByLevelsToOpen(Integer levelsToOpen);

    /**
     * Removes the attachment with the specified ID.
     *
     * @param id attachment ID
     */
    void delete(Long id);
}
