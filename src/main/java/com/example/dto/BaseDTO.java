package com.example.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseDTO implements Serializable {
    private Integer id;
    private LocalDateTime creationDate;
    private LocalDateTime lastEditDate;

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
