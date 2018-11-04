package com.rs.bnk.fx.services;

import com.rs.bnk.fx.services.domain.ExchangeRate;

public interface FXService {

    double calculateExchangeRate(String fromCurrencyCode, String toCurrencyCode);

    void updateExchangeRate(ExchangeRate exchangeRate);
}
