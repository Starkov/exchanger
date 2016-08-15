package com.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transaction")
public class TransactionEntity extends BaseEntity {

    private LocalDateTime finalDate;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private Action action;

    @ManyToOne //TODO
    @JoinColumn(name = "source_purse_id")
    private PurseEntity source;

    @OneToOne //TODO
    @JoinColumn(name = "destination_purse_id")
    private PurseEntity destination;

    private String description;

    @Column(nullable = false)
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

    public PurseEntity getSource() {
        return source;
    }

    public void setSource(PurseEntity source) {
        this.source = source;
    }

    public PurseEntity getDestination() {
        return destination;
    }

    public void setDestination(PurseEntity destination) {
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
