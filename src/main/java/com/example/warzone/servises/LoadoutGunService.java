package com.example.warzone.servises;

import com.example.warzone.dtos.LoadoutGunDto;

import java.util.List;
import java.util.Optional;

public interface LoadoutGunService {
    List<LoadoutGunDto> getAll();

    Optional<LoadoutGunDto> get(Long id);

    LoadoutGunDto register(LoadoutGunDto loadoutGunDto);

    LoadoutGunDto update(LoadoutGunDto loadoutGunDto);

    void delete(Long id);

    List<LoadoutGunDto> findAllByAttachment_1(String attachment_1);

    List<LoadoutGunDto> findAllByAttachment_2(String attachment_2);

    List<LoadoutGunDto> findAllByAttachment_3(String attachment_3);

    List<LoadoutGunDto> findAllByAttachment_4(String attachment_4);

    List<LoadoutGunDto> findAllByAttachment_5(String attachment_5);

    List<LoadoutGunDto> findAllByAttachment_customization_1(String attachment_customization_1);

    List<LoadoutGunDto> findAllByAttachment_customization_2(String attachment_customization_2);

    List<LoadoutGunDto> findAllByAttachment_customization_3(String attachment_customization_3);

    List<LoadoutGunDto> findAllByAttachment_customization_4(String attachment_customization_4);

    List<LoadoutGunDto> findAllByAttachment_customization_5(String attachment_customization_5);

    List<LoadoutGunDto> findAllByRange(String range);

    List<LoadoutGunDto> findAllByName(String name);
}
