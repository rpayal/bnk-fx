package com.rs.bnk.fx.data;

import com.rs.bnk.fx.data.entity.XChangeRateEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface XChangeRateEntityRepository extends CrudRepository<XChangeRateEntity, Long>{

    @Query("from exchangeRate rate" +
            " join currency fromCur on rate.fromCurrencyCode = fromCur.id" +
            " join currency toCur on rate.toCurrencyCode = toCur.id" +
            " where fromCur.currencyCode = :fromCurrencyCode and" +
            "   toCur.currencyCode = :toCurrencyCode")
    XChangeRateEntity findXChangeRateByCurrencyCode(@Param("fromCurrencyCode") String fromCurrencyCode, @Param("toCurrencyCode") String toCurrencyCode);
}
