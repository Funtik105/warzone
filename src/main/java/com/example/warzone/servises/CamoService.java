package com.example.warzone.servises;

import com.example.warzone.dtos.camoserivce.CamoDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CamoService {
    List<CamoDto> getAll();

    List<CamoDto> findByGameRepresents(String gameRepresents);
    List<CamoDto> findByGunName(String gunName);
    List<CamoDto> findCamosByGunId(Long gun_id);

    Optional<CamoDto> get(Long id);

    CamoDto register(CamoDto camoDto);

    CamoDto update(CamoDto camoDto);

    void delete(Long id);
}
