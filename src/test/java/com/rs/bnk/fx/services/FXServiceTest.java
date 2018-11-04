package com.rs.bnk.fx.services;

import com.rs.bnk.fx.data.CurrencyEntityRepository;
import com.rs.bnk.fx.data.XChangeRateEntityRepository;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
//@Sql("/test-data.sql")
public class FXServiceTest {

    @Autowired
    private XChangeRateEntityRepository xChangeRateEntityRepository;

    @Autowired
    private CurrencyEntityRepository currencyRepository;

    private FXService fxService;

    @Before
    public void setup(){
        fxService = new FXServiceImpl(currencyRepository, xChangeRateEntityRepository);
        ReflectionTestUtils.setField(fxService, "baseCurrencyCode", "USD");
    }

   @Test
    public void shouldReturnRateAsOneForUSDToUSD() {
       assertThat( fxService.calculateExchangeRate("USD", "USD"), Is.is(1.0));
    }

    @Test
    public void shouldReturnRateForUSDToINR() {
        assertThat( fxService.calculateExchangeRate("USD", "INR"), Is.is(50.0));
    }

    @Test
    public void shouldReturnRateAsOneForINRToUSD() {
        assertThat( fxService.calculateExchangeRate("INR", "USD"), Is.is(0.02));
    }

    @Test
    public void shouldReturnRateAsOneForINRToINR() {
        assertThat( fxService.calculateExchangeRate("INR", "INR"), Is.is(1.0));
    }

    @Test
    public void shouldReturnRateAsOneForGBPToINR() {
        assertThat( fxService.calculateExchangeRate("GBP", "INR"), Is.is(100.0));
    }

    @Test
    public void shouldReturnRateAsOneForCADToINR() {
        assertThat( fxService.calculateExchangeRate("CAD", "INR"), Is.is(25.0));
    }

    @Test
    public void updateExchangeRate() {
    }
}