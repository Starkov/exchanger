package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "purse_type")
public class PurseTypeEntity extends BaseEntity {

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purseType")
    private Set<PurseEntity> purses;

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

    public Set<PurseEntity> getPurses() {
        return purses;
    }

    public void setPurses(Set<PurseEntity> purses) {
        this.purses = purses;
    }
}
