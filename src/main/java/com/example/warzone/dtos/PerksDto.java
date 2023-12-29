package com.example.warzone.dtos;

public class PerksDto {
    private Long id;
    private LoadoutDto loadout;
    private String name;
    private String description;
    private String slot;

    protected PerksDto() {
    }

    public PerksDto(Long id, LoadoutDto loadout, String slot, String name, String description) {
        this.id = id;
        this.loadout = loadout;
        this.slot = slot;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoadoutDto getLoadout() {
        return loadout;
    }

    public void setLoadout(LoadoutDto loadout) {
        this.loadout = loadout;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
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

    @Override
    public String toString() {
        return "PerksDto{" +
                "id=" + id +
                ", loadout=" + loadout +
                ", type='" + slot + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
