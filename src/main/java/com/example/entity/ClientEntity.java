package com.example.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "person")
@DiscriminatorValue("CLIENT")
public class ClientEntity extends PersonEntity {

    @OneToMany(mappedBy = "client")
    private Set<PurseEntity> purses;


    public Set<PurseEntity> getPurses() {
        return purses;
    }

    public void setPurses(Set<PurseEntity> purses) {
        this.purses = purses;
    }
}
