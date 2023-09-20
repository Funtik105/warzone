package com.example.warzone.models;

public class Attachments extends Base{
    private String name;
    private String weaponsToOpen;
    private short levelsToOpen;
    private String advantages;
    private String disadvantages;
    private String settingLimits;

    protected Attachments() {};

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
