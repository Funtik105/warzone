package com.example.warzone.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;;

import java.util.List;


@Entity
public class NerfsAndBuffs extends Base {
    private String date;
    private String patchName;
    @OneToMany(mappedBy = "nerfsAndBuffs")
    private List<RebalancedGun> rebalancedGun;
    public NerfsAndBuffs() {
    }

    public String getPatchName() {
        return patchName;
    }

    public void setPatchName(String patchName) {
        this.patchName = patchName;
    }

    public List<RebalancedGun> getRebalancedGun() {
        return rebalancedGun;
    }

    public void setRebalancedGun(List<RebalancedGun> rebalancedGun) {
        this.rebalancedGun = rebalancedGun;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
