package com.example.warzone.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Perks extends Base{
    @ManyToOne
    @JoinColumn(name = "loadOut_id")
    private Loadout loadOut;
    private String type;
    private String name;
    private String description;

    protected Perks() {};

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
