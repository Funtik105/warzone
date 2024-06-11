package com.example.warzone.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class RebalancedGunDto {
    private Long id;
    private boolean status;
    private List<String> changes;
    private Long nerfsAndBuffsId;
    private GunDto gun;

    public RebalancedGunDto() {
    }

    public RebalancedGunDto(Long id, boolean status, List<String> changes, Long nerfsAndBuffsId, GunDto gun) {
        this.id = id;
        this.status = status;
        this.changes = changes;
        this.nerfsAndBuffsId = nerfsAndBuffsId;
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

    public Long getNerfsAndBuffsId() {
        return nerfsAndBuffsId;
    }

    public void setNerfsAndBuffsId(Long nerfsAndBuffsId) {
        this.nerfsAndBuffsId = nerfsAndBuffsId;
    }

    @Override
    public String toString() {
        return "RebalancedGunDto{" +
                "id=" + id +
                ", status=" + status +
                ", changes=" + changes +
                ", nerfsAndBuffsId=" + nerfsAndBuffsId +
                ", gun=" + gun +
                '}';
    }
}
