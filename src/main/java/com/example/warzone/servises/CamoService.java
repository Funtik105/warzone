package com.example.warzone.servises;

import com.example.warzone.dtos.CamoDto;

import java.util.List;
import java.util.Optional;

public interface CamoService {
    List<CamoDto> getAll();
    List<CamoDto> findByGameRepresents(String gameRepresents);
    List<CamoDto> findByGunName(String gunName);
    List<CamoDto> findCamosByTitle(String title);
    List<CamoDto> findCamosByStatus(boolean status);
    List<CamoDto> findCamosByGunId(Long gun_id);

    Optional<CamoDto> get(Long id);

    CamoDto register(CamoDto camoDto);

    CamoDto update(CamoDto camoDto);

    void delete(Long id);
}
