package com.example.warzone.dtos;

public class NerfsAndBuffsDto {
    private Long id;
    private GunDto gun;
    private String date;
    private String nameGun;
    private boolean status;
    private String changes;

    public NerfsAndBuffsDto(Long id, GunDto gun, String date, String nameGun,
                            boolean status, String changes) {
        this.id = id;
        this.gun = gun;
        this.date = date;
        this.nameGun = nameGun;
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

    @Override
    public String toString() {
        return "NerfsAndBuffsDto{" +
                "id=" + id +
                ", gun=" + gun +
                ", date='" + date + '\'' +
                ", nameGun='" + nameGun + '\'' +
                ", status=" + status +
                ", changes='" + changes + '\'' +
                '}';
    }
}
