package com.example.warzone.dtos;


public class UsersDto {
    private Long id;
    private String email;
    private String name;
    private String nickname;
    private String description;
    private String visibility;
    private String avatar;
    private String password;
    private int followers;

    protected UsersDto() {};

    public UsersDto(Long id,String email, String name, String nickname, String description, String visibility, String avatar, String password, int followers) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.description = description;
        this.visibility = visibility;
        this.avatar = avatar;
        this.password = password;
        this.followers = followers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setFollowers(int followers) {
        this.followers = followers;
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
                ", followers=" + followers +
                '}';
    }
}
