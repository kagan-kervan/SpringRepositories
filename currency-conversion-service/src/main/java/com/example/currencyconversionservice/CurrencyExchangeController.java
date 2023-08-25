package com.example.currencyconversionservice;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SpringBootApplication
@RestController
public class CurrencyExchangeController
{
    public static final String converterWebURL = "https://openexchangerates.org/api/";
    private static final String API_key = "a6e0e63fae7e488ca826c12fa728c1a6";
    public static final String URL_substring = "/latest.json?app_id=";

    @GetMapping("/currency-exchange/from/{from}/to/{to}/value/{value}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable String value) throws JsonProcessingException {
        double conversionResult = 0;
        String fromStr = from.toUpperCase(Locale.ENGLISH);
        String toStr = to.toUpperCase(Locale.ENGLISH);
        double valueDouble = Double.parseDouble(value);
        RestTemplate restTemplate = new RestTemplate();
        String tempURL = converterWebURL+URL_substring+API_key+"&symbols="+fromStr+","+toStr;
        ResponseEntity<String> response = restTemplate.getForEntity(tempURL,String.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode fromValue = root.findValue(fromStr);
            JsonNode toValue = root.findValue(toStr);
            conversionResult = (valueDouble/fromValue.doubleValue())*toValue.doubleValue();
            ExchangeValue exchangeValue = new ExchangeValue(1L,fromStr,toStr,conversionResult);
            return exchangeValue;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
