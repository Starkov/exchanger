package com.example.dto;

import java.math.BigDecimal;

public class PurseDTO extends BaseDTO {

    private String number;

    private BigDecimal balance;

    private PurseTypeDTO purseType;

    private CurrencyDTO currency;

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

    public PurseTypeDTO getPurseType() {
        return purseType;
    }

    public void setPurseType(PurseTypeDTO purseType) {
        this.purseType = purseType;
    }

    public CurrencyDTO getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDTO currency) {
        this.currency = currency;
    }
}
