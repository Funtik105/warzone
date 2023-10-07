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
}
