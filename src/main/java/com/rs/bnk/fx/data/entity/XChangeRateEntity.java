package com.rs.bnk.fx.data.entity;

import javax.persistence.*;

@Entity(name = "exchangeRate")
@Table(name = "XCHANGE_RATE")
public class XChangeRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long fromCurrencyCode;
    private Long toCurrencyCode;
    private double rate;

    public XChangeRateEntity() {
    }

    public XChangeRateEntity(Long fromCurrencyCode, Long toCurrencyCode, double rate) {
        this.fromCurrencyCode = fromCurrencyCode;
        this.toCurrencyCode = toCurrencyCode;
        this.rate = rate;
    }

    public Long getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    public void setFromCurrencyCode(Long fromCurrencyCode) {
        this.fromCurrencyCode = fromCurrencyCode;
    }

    public Long getToCurrencyCode() {
        return toCurrencyCode;
    }

    public void setToCurrencyCode(Long toCurrencyCode) {
        this.toCurrencyCode = toCurrencyCode;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
