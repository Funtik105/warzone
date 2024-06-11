package com.example.warzone.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Attachments extends Base {
    @ManyToOne
    @JoinColumn(name = "loadoutGun_id")
    private LoadoutGun loadoutGun;
    private String name;
    private String type;
    @OneToOne
    private Gun gun;
    private Integer levelsToOpen;
    @ElementCollection
    private List<String> advantages;
    @ElementCollection
    private List<String> disadvantages;

//    protected Attachments() {
//    }
    public Attachments(){}

    public LoadoutGun getLoadoutGun() {
        return loadoutGun;
    }

    public void setLoadoutGun(LoadoutGun loadoutGun) {
        this.loadoutGun = loadoutGun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
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
    public static Attachments createAttachment() {
        Attachments attachment = new Attachments();
        return attachment;
    }
}
