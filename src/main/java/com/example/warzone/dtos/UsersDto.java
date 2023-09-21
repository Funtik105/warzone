package com.example.warzone.dtos;

import java.awt.*;

public class UsersDto {
    private String email;
    private String name;
    private String nickname;
    private String description;
    private String visibility;
    private Image avatar;
    private String password;
    private int folowers;

    protected UsersDto() {};

    public UsersDto(String email, String name, String nickname, String description, String visibility, Image avatar, String password, int folowers) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.description = description;
        this.visibility = visibility;
        this.avatar = avatar;
        this.password = password;
        this.folowers = folowers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFolowers() {
        return folowers;
    }

    public void setFolowers(int folowers) {
        this.folowers = folowers;
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", description='" + description + '\'' +
                ", visibility='" + visibility + '\'' +
                ", avatar=" + avatar +
                ", password='" + password + '\'' +
                ", folowers=" + folowers +
                '}';
    }
}
