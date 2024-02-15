package com.example.warzone.dtos;

import com.example.warzone.dtos.gunservice.GunDto;

public class LoadoutGunDto {
    private Long id;
    private GunDto gun;
    private LoadoutDto loadout;
    private MetaListDto metaList;
    private String name;
    private String range;
    private String attachment_1;
    private String attachment_2;
    private String attachment_3;
    private String attachment_4;
    private String attachment_5;

    protected LoadoutGunDto() {
    }

    public LoadoutGunDto(Long id, GunDto gun, LoadoutDto loadout, MetaListDto metaList, String name, String range, String attachment_1, String attachment_2, String attachment_3, String attachment_4, String attachment_5) {
        this.id = id;
        this.gun = gun;
        this.loadout = loadout;
        this.metaList = metaList;
        this.name = name;
        this.range = range;
        this.attachment_1 = attachment_1;
        this.attachment_2 = attachment_2;
        this.attachment_3 = attachment_3;
        this.attachment_4 = attachment_4;
        this.attachment_5 = attachment_5;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GunDto getGun() {
        return gun;
    }

    public void setGun(GunDto gun) {
        this.gun = gun;
    }

    public LoadoutDto getLoadout() {
        return loadout;
    }

    public void setLoadout(LoadoutDto loadout) {
        this.loadout = loadout;
    }

    public MetaListDto getMetaList() {
        return metaList;
    }

    public void setMetaList(MetaListDto metaList) {
        this.metaList = metaList;
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
}
