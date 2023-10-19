package com.example.warzone.dtos;

import org.springframework.data.annotation.CreatedDate;

public class LoadoutDto {
    private Long id;
    private UsersDto user;
    private String perks;
    private String guns;
    private String description;
    private String date;
    private String updatedAt;
    private String enabled;

    protected LoadoutDto() {};

    public LoadoutDto(Long id, UsersDto user, String perks, String guns, String description, String date, String updatedAt, String enabled) {
        this.id = id;
        this.user = user;
        this.perks = perks;
        this.guns = guns;
        this.description = description;
        this.date = date;
        this.updatedAt = updatedAt;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsersDto getUser() {
        return user;
    }

    public void setUser(UsersDto user) {
        this.user = user;
    }

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

    @Override
    public String toString() {
        return "LoadoutDto{" +
                "id=" + id +
                ", user=" + user +
                ", perks='" + perks + '\'' +
                ", guns='" + guns + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", enabled='" + enabled + '\'' +
                '}';
    }
}
