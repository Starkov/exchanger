package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "person")
@DiscriminatorValue("CLIENT")
public class ClientEntity extends PersonEntity {

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<PurseEntity> purses;


    public List<PurseEntity> getPurses() {
        return purses;
    }

    public void setPurses(List<PurseEntity> purses) {
        this.purses = purses;
    }
}
