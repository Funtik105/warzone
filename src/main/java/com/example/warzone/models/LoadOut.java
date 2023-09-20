package com.example.warzone.models;

import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class LoadOut extends Base{
    private String perks;
    private String guns;
    private String description;
    private CreatedDate date;
    private String updatedAt;
    private String enabled;

    protected LoadOut() {};

    public String getPerks() {
        return perks;
    }

    public void setPerks(String perks) {
        this.perks = perks;
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

    public CreatedDate getDate() {
        return date;
    }

    public void setDate(CreatedDate date) {
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
