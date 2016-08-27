package com.example.dto;


import com.example.entity.Action;
import com.example.entity.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO extends BaseDTO {
    private LocalDateTime finalDate;
    private BigDecimal amount;
    private Action action;
    private PurseDTO source;
    private PurseDTO destination;
    private String description;
    private Status status;

    public LocalDateTime getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDateTime finalDate) {
        this.finalDate = finalDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public PurseDTO getSource() {
        return source;
    }

    public void setSource(PurseDTO source) {
        this.source = source;
    }

    public PurseDTO getDestination() {
        return destination;
    }

    public void setDestination(PurseDTO destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
