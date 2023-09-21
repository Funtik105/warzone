package com.example.warzone.dtos;

public class LoadOutGunDto {
    private String name;
    private String rage;
    private String attachment_1;
    private String attachment_customization_1;
    private String attachment_2;
    private String attachment_customization_2;
    private String attachment_3;
    private String attachment_customization_3;
    private String attachment_4;
    private String attachment_customization_4;
    private String attachment_5;
    private String attachment_customization_5;

    protected LoadOutGunDto() {};

    public LoadOutGunDto(String name, String rage, String attachment_1, String attachment_customization_1, String attachment_2, String attachment_customization_2, String attachment_3, String attachment_customization_3, String attachment_4, String attachment_customization_4, String attachment_5, String attachment_customization_5) {
        this.name = name;
        this.rage = rage;
        this.attachment_1 = attachment_1;
        this.attachment_customization_1 = attachment_customization_1;
        this.attachment_2 = attachment_2;
        this.attachment_customization_2 = attachment_customization_2;
        this.attachment_3 = attachment_3;
        this.attachment_customization_3 = attachment_customization_3;
        this.attachment_4 = attachment_4;
        this.attachment_customization_4 = attachment_customization_4;
        this.attachment_5 = attachment_5;
        this.attachment_customization_5 = attachment_customization_5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRage() {
        return rage;
    }

    public void setRage(String rage) {
        this.rage = rage;
    }

    public String getAttachment_1() {
        return attachment_1;
    }

    public void setAttachment_1(String attachment_1) {
        this.attachment_1 = attachment_1;
    }

    public String getAttachment_customization_1() {
        return attachment_customization_1;
    }

    public void setAttachment_customization_1(String attachment_customization_1) {
        this.attachment_customization_1 = attachment_customization_1;
    }

    public String getAttachment_2() {
        return attachment_2;
    }

    public void setAttachment_2(String attachment_2) {
        this.attachment_2 = attachment_2;
    }

    public String getAttachment_customization_2() {
        return attachment_customization_2;
    }

    public void setAttachment_customization_2(String attachment_customization_2) {
        this.attachment_customization_2 = attachment_customization_2;
    }

    public String getAttachment_3() {
        return attachment_3;
    }

    public void setAttachment_3(String attachment_3) {
        this.attachment_3 = attachment_3;
    }

    public String getAttachment_customization_3() {
        return attachment_customization_3;
    }

    public void setAttachment_customization_3(String attachment_customization_3) {
        this.attachment_customization_3 = attachment_customization_3;
    }

    public String getAttachment_4() {
        return attachment_4;
    }

    public void setAttachment_4(String attachment_4) {
        this.attachment_4 = attachment_4;
    }

    public String getAttachment_customization_4() {
        return attachment_customization_4;
    }

    public void setAttachment_customization_4(String attachment_customization_4) {
        this.attachment_customization_4 = attachment_customization_4;
    }

    public String getAttachment_5() {
        return attachment_5;
    }

    public void setAttachment_5(String attachment_5) {
        this.attachment_5 = attachment_5;
    }

    public String getAttachment_customization_5() {
        return attachment_customization_5;
    }

    public void setAttachment_customization_5(String attachment_customization_5) {
        this.attachment_customization_5 = attachment_customization_5;
    }

    @Override
    public String toString() {
        return "LoadOutGunDto{" +
                "name='" + name + '\'' +
                ", rage='" + rage + '\'' +
                ", attachment_1='" + attachment_1 + '\'' +
                ", attachment_customization_1='" + attachment_customization_1 + '\'' +
                ", attachment_2='" + attachment_2 + '\'' +
                ", attachment_customization_2='" + attachment_customization_2 + '\'' +
                ", attachment_3='" + attachment_3 + '\'' +
                ", attachment_customization_3='" + attachment_customization_3 + '\'' +
                ", attachment_4='" + attachment_4 + '\'' +
                ", attachment_customization_4='" + attachment_customization_4 + '\'' +
                ", attachment_5='" + attachment_5 + '\'' +
                ", attachment_customization_5='" + attachment_customization_5 + '\'' +
                '}';
    }
}
