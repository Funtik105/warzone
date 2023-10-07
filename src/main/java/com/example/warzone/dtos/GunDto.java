package com.example.warzone.dtos;

public class GunDto {
    private Long id;
    private String name;
    private String category;
    private String platform;

    protected GunDto() {};

    public GunDto(Long id,String name, String category, String platform) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.platform = platform;
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
