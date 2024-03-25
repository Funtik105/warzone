package com.example.warzone.dtos;

public class CamoDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private boolean status;

    protected CamoDto() {
    }

    public CamoDto(Long id, String title, String description, String image, boolean status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
