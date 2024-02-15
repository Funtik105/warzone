package com.example.warzone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class MetaList extends Base {
    @OneToMany(mappedBy = "metaList")
    private List<LoadoutGun> loadoutGuns;
    private String name;
    private String range;
    private String gun1;
    private String category;
    private String attachment_1;
    private String attachment_2;
    private String attachment_3;
    private String attachment_4;
    private String attachment_5;

    protected MetaList() {
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

    public String getAttachment_2() {
        return attachment_2;
    }

    public void setAttachment_2(String attachment_2) {
        this.attachment_2 = attachment_2;
    }

    public String getAttachment_3() {
        return attachment_3;
    }

    public void setAttachment_3(String attachment_3) {
        this.attachment_3 = attachment_3;
    }

    public String getAttachment_4() {
        return attachment_4;
    }

    public void setAttachment_4(String attachment_4) {
        this.attachment_4 = attachment_4;
    }

    public String getAttachment_5() {
        return attachment_5;
    }

    public void setAttachment_5(String attachment_5) {
        this.attachment_5 = attachment_5;
    }
}
