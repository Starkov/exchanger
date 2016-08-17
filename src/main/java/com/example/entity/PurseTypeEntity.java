package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "purse_type")
public class PurseTypeEntity extends BaseEntity {

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purseType")
    private List<PurseEntity> purses;

    public PurseTypeEntity() {
    }

    public PurseTypeEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PurseEntity> getPurses() {
        return purses;
    }

    public void setPurses(List<PurseEntity> purses) {
        this.purses = purses;
    }
}
