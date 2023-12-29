package com.example.warzone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class NerfsAndBuffs extends Base {
    @ManyToOne
    @JoinColumn(name = "gun_id")
    private Gun gun;
    private String nameGun;
    private String date;
    private boolean status;
    private String changes;

    protected NerfsAndBuffs() {
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public String getNameGun() {
        return nameGun;
    }

    public void setNameGun(String nameGun) {
        this.nameGun = nameGun;
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

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }
}
