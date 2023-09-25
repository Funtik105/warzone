package com.example.warzone.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

public class Gun extends Base{
    @OneToMany(mappedBy = "gun")
    private List<NerfsAndBuffs> nerfsAndBuffs;
    @OneToOne(mappedBy = "gun")
    @JoinColumn(name = "loadoutGun_id",referencedColumnName = "id")
    private LoadoutGun loadoutGun;
    private String name;
    private String category;
    private String platform;

    protected Gun() {};

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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
