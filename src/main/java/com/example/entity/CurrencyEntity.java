package com.example.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity(name = "currency")
public class CurrencyEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(STRING)
    private Currency name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "currency")
    private List<PurseEntity> purses;

    public CurrencyEntity() {
    }

    public CurrencyEntity(Currency name) {
        this.name = name;
    }

    public Currency getName() {
        return name;
    }

    public void setName(Currency name) {
        this.name = name;
    }

    public List<PurseEntity> getPurses() {
        return purses;
    }

    public void setPurses(List<PurseEntity> purses) {
        this.purses = purses;
    }
}
