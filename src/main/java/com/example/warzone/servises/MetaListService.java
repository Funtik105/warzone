package com.example.warzone.servises;

import com.example.warzone.dtos.MetaListDto;

import java.util.List;
import java.util.Optional;

public interface MetaListService {
    List<MetaListDto> getAlL();
    Optional<MetaListDto> get(Long id);
    MetaListDto register(MetaListDto metaListDto);
    MetaListDto update(MetaListDto metaListDto);
    void delete(Long id);
    List<MetaListDto> findAllByGun1(String gun1);
    List<MetaListDto> findAllByName(String name);
    List<MetaListDto> findAllByRange(String range);
    List<MetaListDto> findAllByCategory(String category);
    List<MetaListDto> findAllByAttachment_1(String attachment_1);
    List<MetaListDto> findAllByAttachment_2(String attachment_2);
    List<MetaListDto> findAllByAttachment_3(String attachment_3);
    List<MetaListDto> findAllByAttachment_4(String attachment_4);
    List<MetaListDto> findAllByAttachment_5(String attachment_5);
    List<MetaListDto> findAllByAttachment_customization_1(String attachment_customization_1);
    List<MetaListDto> findAllByAttachment_customization_2(String attachment_customization_2);
    List<MetaListDto> findAllByAttachment_customization_3(String attachment_customization_3);
    List<MetaListDto> findAllByAttachment_customization_4(String attachment_customization_4);
    List<MetaListDto> findAllByAttachment_customization_5(String attachment_customization_5);
}
