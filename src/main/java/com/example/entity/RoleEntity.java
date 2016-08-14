package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity(name = "role")
public class RoleEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<PersonEntity> person;

    public RoleEntity() {
    }

    public RoleEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PersonEntity> getPerson() {
        return person;
    }

    public void setPerson(Set<PersonEntity> person) {
        this.person = person;
    }
}
