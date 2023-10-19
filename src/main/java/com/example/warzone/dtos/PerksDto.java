package com.example.warzone.dtos;

public class PerksDto {
    private Long id;
    private LoadoutDto loadout;
    private String type;
    private String name;
    private String description;

    protected PerksDto() {};

    public PerksDto(Long id, LoadoutDto loadout, String type, String name, String description) {
        this.id = id;
        this.loadout = loadout;
        this.type = type;
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

    @Override
    public String toString() {
        return "PerksDto{" +
                "id=" + id +
                ", loadout=" + loadout +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
