package com.example.warzone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Users extends Base{
    @OneToMany(mappedBy = "user")
    private List<Loadout> loadOuts;
    private String email;
    private String name;
    private String nickname;
    private String description;
    private String visibility;
    private String avatar;
    private String password;
    private int followers;

    protected Users() {
    }

    public List<Loadout> getLoadOuts() {
        return loadOuts;
    }

    public void setLoadOuts(List<Loadout> loadOuts) {
        this.loadOuts = loadOuts;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int folowers) {
        this.followers = folowers;
    }
}
