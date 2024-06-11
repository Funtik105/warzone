package com.example.warzone.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Gun extends Base {
    @OneToMany(mappedBy = "gun")
    private List<RebalancedGun> rebalancedGun;
    @OneToOne(mappedBy = "gun")
    private LoadoutGun loadoutGun;
    @OneToMany(mappedBy = "gun")
    private List<Camo> camo;
    @OneToOne(mappedBy = "gun")
    private Attachments attachments;
    private String name;
    private String category;
    private String gameRepresents;

    protected Gun() {
    }

    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<RebalancedGun> getRebalancedGun() {
        return rebalancedGun;
    }

    public void setRebalancedGun(List<RebalancedGun> rebalancedGun) {
        this.rebalancedGun = rebalancedGun;
    }

    public List<Camo> getCamo() {
        return camo;
    }

    public void setCamo(List<Camo> camo) {
        this.camo = camo;
    }

    public LoadoutGun getLoadoutGun() {
        return loadoutGun;
    }

    public void setLoadoutGun(LoadoutGun loadoutGun) {
        this.loadoutGun = loadoutGun;
    }

    public String getGameRepresents() {
        return gameRepresents;
    }

    public void setGameRepresents(String gameRepresents) {
        this.gameRepresents = gameRepresents;
    }
    public static Gun createGun(){
        Gun gun = new Gun();
        gun.setId(1L);
        return gun;
    }
}
