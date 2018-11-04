package com.rs.bnk.fx.services;

import com.rs.bnk.fx.data.CurrencyEntityRepository;
import com.rs.bnk.fx.data.XChangeRateEntityRepository;
import com.rs.bnk.fx.data.entity.XChangeRateEntity;
import com.rs.bnk.fx.services.domain.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Component
public class FXServiceImpl implements FXService {

    @Value("${base.currency.code:USD}")
    private String baseCurrencyCode;

    private CurrencyEntityRepository currencyRepository;

    private XChangeRateEntityRepository xChangeRateRepository;

    @Autowired
    public FXServiceImpl(final CurrencyEntityRepository currencyRepository,
                         final XChangeRateEntityRepository xChangeRateEntityRepository ) {
        this.currencyRepository = currencyRepository;
        this.xChangeRateRepository = xChangeRateEntityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public double calculateExchangeRate(String fromCurrencyCode, String toCurrencyCode) {

        Double exchangeRate;

        XChangeRateEntity xChangeRateEntity = xChangeRateRepository
                .findXChangeRateByCurrencyCode(fromCurrencyCode, toCurrencyCode);

        if(Objects.nonNull(xChangeRateEntity)){
            exchangeRate = xChangeRateEntity.getRate();
        }else{

            XChangeRateEntity fromXChangeRateEntity = xChangeRateRepository
                    .findXChangeRateByCurrencyCode(baseCurrencyCode, fromCurrencyCode);

            if(Objects.isNull(fromXChangeRateEntity)){
                // throw exception
            }

            XChangeRateEntity toXChangeRateEntity = xChangeRateRepository
                    .findXChangeRateByCurrencyCode(baseCurrencyCode, toCurrencyCode);

            if(Objects.isNull(toXChangeRateEntity)){
                // throw exception
            }

            exchangeRate = toXChangeRateEntity.getRate() / fromXChangeRateEntity.getRate();
        }

        return exchangeRate;
    }

    @Override
    public void updateExchangeRate(ExchangeRate exchangeRate) {

    }
}
