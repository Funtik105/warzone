package com.example.warzone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nerfs_and_buffs")
public class NerfsAndBuffs extends Base {
    @ManyToOne
    @JoinColumn(name = "gun_id")
    private Gun gun;
    private String date;
    private String nameGun;
    private boolean status;

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

    private String changes;

    protected NerfsAndBuffs() {
    }
}
