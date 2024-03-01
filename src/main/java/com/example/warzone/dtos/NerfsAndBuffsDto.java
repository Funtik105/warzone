package com.example.warzone.dtos;

import java.util.List;

public class NerfsAndBuffsDto {
    private Long id;
    private GunDto gun;
    private String date;
    private boolean status;
    private List<String> changes;

    public NerfsAndBuffsDto(Long id, GunDto gun, String date, boolean status, List<String> changes) {
        this.id = id;
        this.gun = gun;
        this.date = date;
        this.status = status;
        this.changes = changes;
    }

    protected NerfsAndBuffsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GunDto getGun() {
        return gun;
    }

    public void setGun(GunDto gun) {
        this.gun = gun;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "NerfsAndBuffsDto{" +
                "id=" + id +
                ", gun=" + gun +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", changes=" + changes +
                '}';
    }

}
