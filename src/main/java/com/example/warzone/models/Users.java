package com.example.warzone.models;

import org.apache.catalina.User;

import java.awt.*;

public class Users extends Base{
    private String email;
    private String name;
    private String nickname;
    private String description;
    private String visibility;
    private Image avatar;
    private String password;
    private int folowers;

    protected Users() {};

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
}
