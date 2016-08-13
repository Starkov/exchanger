package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

@Entity(name = "currency")
public class CurrencyEntity extends BaseEntity {

    @Enumerated(STRING)
    private Currency name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "currency")
    private Set<PurseEntity> purses;

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

    public Set<PurseEntity> getPurses() {
        return purses;
    }

    public void setPurses(Set<PurseEntity> purses) {
        this.purses = purses;
    }
}
