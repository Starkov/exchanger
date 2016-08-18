package com.example.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class CommissionId implements Serializable {
    @OneToOne(cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "source_currency_id")
    private CurrencyEntity source;

    @OneToOne(cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "destination_currency_id")
    private CurrencyEntity destination;

    public CurrencyEntity getSource() {
        return source;
    }

    public void setSource(CurrencyEntity sourceCurrencyId) {
        this.source = sourceCurrencyId;
    }

    public CurrencyEntity getDestination() {
        return destination;
    }

    public void setDestination(CurrencyEntity destinationCurrencyId) {
        this.destination = destinationCurrencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommissionId that = (CommissionId) o;

        if (source != null ? !source.equals(that.source) : that.source != null)
            return false;
        return destination != null ? destination.equals(that.destination) : that.destination == null;

    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        return result;
    }
}
