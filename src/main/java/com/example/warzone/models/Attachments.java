package com.example.warzone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attachments")
public class Attachments extends Base {
    @ManyToOne
    @JoinColumn(name = "loadoutGun_id")
    private LoadoutGun loadoutGun;
    private String name;
    private String weaponsToOpen;
    private short levelsToOpen;
    private String advantages;
    private String disadvantages;
    private String settingLimits;

    protected Attachments() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeaponsToOpen() {
        return weaponsToOpen;
    }

    public void setWeaponsToOpen(String weaponsToOpen) {
        this.weaponsToOpen = weaponsToOpen;
    }

    public short getLevelsToOpen() {
        return levelsToOpen;
    }

    public void setLevelsToOpen(short levelsToOpen) {
        this.levelsToOpen = levelsToOpen;
    }

    public String getAdvantages() {
        return advantages;
    }

    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    }

    public String getDisadvantages() {
        return disadvantages;
    }

    public void setDisadvantages(String disadvantages) {
        this.disadvantages = disadvantages;
    }

    public String getSettingLimits() {
        return settingLimits;
    }

    public void setSettingLimits(String settingLimits) {
        this.settingLimits = settingLimits;
    }
}
