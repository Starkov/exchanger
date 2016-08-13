package com.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime creationDate;
    private LocalDateTime lastEditDate;

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDateTime.now();
        preUpdate();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastEditDate = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(LocalDateTime lastEditDate) {
        this.lastEditDate = lastEditDate;
    }
}
