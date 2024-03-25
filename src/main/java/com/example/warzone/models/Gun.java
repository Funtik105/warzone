package com.example.warzone.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gun")
public class Gun extends Base {
    @OneToMany(mappedBy = "gun")
    private List<RebalancedGun> rebalancedGun;
    @OneToOne(mappedBy = "gun")
    private LoadoutGun loadoutGun;
    @OneToMany(mappedBy = "gun")
    private List<Camo> camo;
    private String name;
    private String category;
    private String gameRepresents;

    protected Gun() {
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
}
