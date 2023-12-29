package com.example.warzone.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Loadout extends Base {
    @OneToMany(mappedBy = "loadout")
    private List<LoadoutGun> loadoutGuns;
    @OneToMany(mappedBy = "loadout")
    private List<Perks> perks;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private String perks1;
    private String guns;
    private String description;
    private String date;
    private String updatedAt;
    private String enabled;

    protected Loadout() {
    }

    public String getPerks1() {
        return perks1;
    }

    public void setPerks1(String perks1) {
        this.perks1 = perks1;
    }

    public String getGuns() {
        return guns;
    }

    public void setGuns(String guns) {
        this.guns = guns;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
