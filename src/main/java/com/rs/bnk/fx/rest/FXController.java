package com.rs.bnk.fx.rest;

import com.rs.bnk.fx.services.FXService;
import com.rs.bnk.fx.services.domain.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController("/v1")
public class FXController {

    @Autowired
    private FXService fxService;

    @GetMapping(path = "/exchange-rate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ExchangeRateResponse calculateExchangeRate(@RequestParam("from") String fromCurrencyCode,
                                      @RequestParam("to") String toCurrencyCode){
       Double exchangeRate =  fxService.calculateExchangeRate(fromCurrencyCode, toCurrencyCode);

        return new ExchangeRateResponse(fromCurrencyCode, toCurrencyCode, exchangeRate);
    }
}
