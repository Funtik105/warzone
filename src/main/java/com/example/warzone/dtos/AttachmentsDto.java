package com.example.warzone.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class AttachmentsDto {
    private Long id;
    @JsonIgnore
    private LoadoutGunDto loadoutGun;
    private String name;
    private GunDto gun;
    private String type;
    private Integer levelsToOpen;
    private List<String> advantages;
    private List<String> disadvantages;

    public AttachmentsDto() {
    }

    public AttachmentsDto(Long id, LoadoutGunDto loadoutGun, String name, GunDto gun, String type, Integer levelsToOpen, List<String> advantages, List<String> disadvantages) {
        this.id = id;
        this.loadoutGun = loadoutGun;
        this.name = name;
        this.gun = gun;
        this.type = type;
        this.levelsToOpen = levelsToOpen;
        this.advantages = advantages;
        this.disadvantages = disadvantages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoadoutGunDto getLoadoutGun() {
        return loadoutGun;
    }

    public void setLoadoutGun(LoadoutGunDto loadoutGun) {
        this.loadoutGun = loadoutGun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GunDto getGun() {
        return gun;
    }

    public void setGun(GunDto gun) {
        this.gun = gun;
    }

    public Integer getLevelsToOpen() {
        return levelsToOpen;
    }

    public void setLevelsToOpen(Integer levelsToOpen) {
        this.levelsToOpen = levelsToOpen;
    }

    public List<String> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(List<String> advantages) {
        this.advantages = advantages;
    }

    public List<String> getDisadvantages() {
        return disadvantages;
    }

    public void setDisadvantages(List<String> disadvantages) {
        this.disadvantages = disadvantages;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
