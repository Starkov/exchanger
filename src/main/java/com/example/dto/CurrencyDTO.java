package com.example.dto;

import com.example.entity.Currency;

public class CurrencyDTO extends BaseDTO {

    private Currency name;

    public Currency getName() {
        return name;
    }

    public void setName(Currency name) {
        this.name = name;
    }
}
