package com.example.warzone.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LoadoutGun extends Base {
    @OneToOne
    @JoinColumn(name = "gun_id")
    private Gun gun;
    @OneToMany(mappedBy = "loadoutGun")
    private List<Attachments> attachments;
    @ManyToOne
    @JoinColumn(name = "metalist_id")
    private MetaList metaList;
    @ManyToOne
    @JoinColumn(name = "loadout_id")
    private Loadout loadout;
    private String name;
    private String range;
    private String attachment_1;
    private String attachment_2;
    private String attachment_3;
    private String attachment_4;
    private String attachment_5;

    protected LoadoutGun() {
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
    }

    public MetaList getMetaList() {
        return metaList;
    }

    public void setMetaList(MetaList metaList) {
        this.metaList = metaList;
    }

    public Loadout getLoadout() {
        return loadout;
    }

    public void setLoadout(Loadout loadout) {
        this.loadout = loadout;
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
    public static LoadoutGun createLoadoutGun(){
        LoadoutGun loadoutGun = new LoadoutGun();
        loadoutGun.setId(1L);
        return loadoutGun;
    }
}
