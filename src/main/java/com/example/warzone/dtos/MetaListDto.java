package com.example.warzone.dtos;

public class MetaListDto {
    private Long id;
    private String name;
    private String range;
    private String gun1;
    private String category;
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

    protected MetaListDto() {
    }

    public MetaListDto(Long id, String name, String range, String gun1, String category, String attachment_1, String attachment_customization_1, String attachment_2, String attachment_customization_2, String attachment_3, String attachment_customization_3, String attachment_4, String attachment_customization_4, String attachment_5, String attachment_customization_5) {
        this.id = id;
        this.name = name;
        this.range = range;
        this.gun1 = gun1;
        this.category = category;
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

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getGun1() {
        return gun1;
    }

    public void setGun1(String gun1) {
        this.gun1 = gun1;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        return "MetaListDto{" +
                "name='" + name + '\'' +
                ", range=" + range +
                ", gun1='" + gun1 + '\'' +
                ", category='" + category + '\'' +
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
