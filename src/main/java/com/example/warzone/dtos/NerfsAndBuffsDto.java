package com.example.warzone.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

public class NerfsAndBuffsDto {
    private Long id;
    private String patchName;
    private List<RebalancedGunDto> rebalancedGun;
    private String date;

    public NerfsAndBuffsDto(Long id, String patchName, List<RebalancedGunDto> rebalancedGun, String date) {
        this.id = id;
        this.patchName = patchName;
        this.rebalancedGun = rebalancedGun;
        this.date = date;
    }

    protected NerfsAndBuffsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatchName() {
        return patchName;
    }

    public void setPatchName(String patchName) {
        this.patchName = patchName;
    }

    public void setRebalancedGun(List<RebalancedGunDto> rebalancedGun) {
        this.rebalancedGun = rebalancedGun;
    }

    public List<RebalancedGunDto> getRebalancedGun() {
        return rebalancedGun;
    }

    public void setRebalancedGunDto(List<RebalancedGunDto> rebalancedGun) {
        this.rebalancedGun = rebalancedGun;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NerfsAndBuffsDto{" +
                "id=" + id +
                ", rebalancedGun=" + rebalancedGun +
                ", date='" + date + '\'' +
                '}';
    }
}
