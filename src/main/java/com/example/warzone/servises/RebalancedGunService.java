package com.example.warzone.servises;

import com.example.warzone.dtos.RebalancedGunDto;

import java.util.List;
import java.util.Optional;

public interface RebalancedGunService {
    List<RebalancedGunDto> getAll();

    Optional<RebalancedGunDto> get(Long id);

    RebalancedGunDto register(RebalancedGunDto rebalancedGunDto);

    void delete(Long id);

}
