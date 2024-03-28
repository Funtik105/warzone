package com.example.warzone.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class RebalancedGunDto {
    private Long id;
    private boolean status;

    private List<String> changes;
    @JsonIgnore
    private NerfsAndBuffsDto nerfsAndBuffs;
    private GunDto gun;

    protected RebalancedGunDto() {
    }

    public RebalancedGunDto(Long id, boolean status, List<String> changes, NerfsAndBuffsDto nerfsAndBuffs, GunDto gun) {
        this.id = id;
        this.status = status;
        this.changes = changes;
        this.nerfsAndBuffs = nerfsAndBuffs;
        this.gun = gun;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getChanges() {
        return changes;
    }

    public void setChanges(List<String> changes) {
        this.changes = changes;
    }

    public GunDto getGun() {
        return gun;
    }

    public void setGun(GunDto gun) {
        this.gun = gun;
    }

    public NerfsAndBuffsDto getNerfsAndBuffs() {
        return nerfsAndBuffs;
    }

    public void setNerfsAndBuffs(NerfsAndBuffsDto nerfsAndBuffs) {
        this.nerfsAndBuffs = nerfsAndBuffs;
    }

    @Override
    public String toString() {
        return "RebalancedGunDto{" +
                "id=" + id +
                ", status=" + status +
                ", changes=" + changes +
                ", nerfsAndBuffs=" + nerfsAndBuffs +
                ", gun=" + gun +
                '}';
    }
}
