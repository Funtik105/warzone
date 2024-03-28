package com.example.warzone.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rebalanced_gun")
public class RebalancedGun extends Base{
    private boolean status;
    @ElementCollection
    private List<String> changes;
    @ManyToOne
    @JoinColumn(name = "nerfsAndBuffs_id")
    private NerfsAndBuffs nerfsAndBuffs;
    @ManyToOne
    @JoinColumn(name = "gun_id")
    private Gun gun;

    protected RebalancedGun() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getChanges() {
        return changes;
    }

    public void setChanges(List<String> changes) {
        this.changes = changes;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public NerfsAndBuffs getNerfsAndBuffs() {
        return nerfsAndBuffs;
    }

    public void setNerfsAndBuffs(NerfsAndBuffs nerfsAndBuffs) {
        this.nerfsAndBuffs = nerfsAndBuffs;
    }
}
