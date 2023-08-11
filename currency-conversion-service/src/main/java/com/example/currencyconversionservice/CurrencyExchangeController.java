package com.example.currencyconversionservice;

import java.math.BigDecimal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;
@SpringBootApplication
@RestController
public class CurrencyExchangeController
{
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
    {
        ExchangeValue val = new ExchangeValue(1000L,from,to,BigDecimal.valueOf(65));
        return new ExchangeValue(1000L,from,to,BigDecimal.valueOf(65));
    }
}
