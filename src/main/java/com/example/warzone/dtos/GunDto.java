package com.example.warzone.dtos;

public class GunDto {
    private String name;
    private String category;
    private String platform;

    protected GunDto() {};

    public GunDto(String name, String category, String platform) {
        this.name = name;
        this.category = category;
        this.platform = platform;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "GunDto{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
