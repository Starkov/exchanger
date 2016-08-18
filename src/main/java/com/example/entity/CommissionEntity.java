package com.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "commission")
public class CommissionEntity {
    @EmbeddedId
    private CommissionId id;
    @Column(nullable = false)
    private Integer amount;
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

    public CommissionId getId() {
        return id;
    }

    public void setId(CommissionId id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
