package com.example.warzone.dtos;

public class AttachmentsDto {
    private Long id;
    private LoadoutGunDto loadoutGun;
    private String name;
    private String weaponsToOpen;
    private short levelsToOpen;
    private String advantages;
    private String disadvantages;
    private String settingLimits;

    protected AttachmentsDto() {};

    public AttachmentsDto(Long id, LoadoutGunDto loadoutGun, String name, String weaponsToOpen, short levelsToOpen, String advantages, String disadvantages, String settingLimits) {
        this.id = id;
        this.loadoutGun = loadoutGun;
        this.name = name;
        this.weaponsToOpen = weaponsToOpen;
        this.levelsToOpen = levelsToOpen;
        this.advantages = advantages;
        this.disadvantages = disadvantages;
        this.settingLimits = settingLimits;
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

    @Override
    public String toString() {
        return "AttachmentsDto{" +
                "id=" + id +
                ", loadoutGun=" + loadoutGun +
                ", name='" + name + '\'' +
                ", weaponsToOpen='" + weaponsToOpen + '\'' +
                ", levelsToOpen=" + levelsToOpen +
                ", advantages='" + advantages + '\'' +
                ", disadvantages='" + disadvantages + '\'' +
                ", settingLimits='" + settingLimits + '\'' +
                '}';
    }
}
