package com.example.warzone.dtos;

public class GunDto {
    private Long id;
    private String name;
    private String category;
    private String gameRepresents;

    public GunDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGameRepresents() {
        return gameRepresents;
    }

    public void setGameRepresents(String gameRepresents) {
        this.gameRepresents = gameRepresents;
    }

    @Override
    public String toString() {
        return "GunDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", gameRepresents='" + gameRepresents + '\'' +
                '}';
    }
}
