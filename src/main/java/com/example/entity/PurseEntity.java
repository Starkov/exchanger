package com.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "purse")
public class PurseEntity extends BaseEntity {

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purse_type_id", nullable = false)
    private PurseTypeEntity purseType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_id", nullable = false)
    private CurrencyEntity currency;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public PurseTypeEntity getPurseType() {
        return purseType;
    }

    public void setPurseType(PurseTypeEntity purseType) {
        this.purseType = purseType;
    }

    public CurrencyEntity getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEntity currency) {
        this.currency = currency;
    }
}
