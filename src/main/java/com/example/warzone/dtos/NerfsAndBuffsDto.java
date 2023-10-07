package com.example.warzone.dtos;

public class NerfsAndBuffsDto {
    private Long id;
    private String date;

    private String nameGun;
    private  boolean status;
    private String changes;

    public NerfsAndBuffsDto(Long id,String date, String nameGun, boolean status, String changes) {
        this.id = id;
        this.date = date;
        this.nameGun = nameGun;
        this.status = status;
        this.changes = changes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNameGun() {
        return nameGun;
    }

    public void setNameGun(String nameGun) {
        this.nameGun = nameGun;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }
}
