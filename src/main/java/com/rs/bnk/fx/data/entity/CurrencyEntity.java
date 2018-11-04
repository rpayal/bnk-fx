package com.rs.bnk.fx.data.entity;

import javax.persistence.*;

@Entity(name = "currency")
@Table(name = "CURRENCY")
public class CurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String currencyCode;
    private String currencyDesc;

    public CurrencyEntity() {
    }

    public CurrencyEntity(String currencyCode, String currencyDesc) {
        this.currencyCode = currencyCode;
        this.currencyDesc = currencyDesc;
    }
}
