package com.example.currencyconversionservice;
import java.math.BigDecimal;
public class ExchangeValue
{
    private Long id;
    private String from;
    private String to;

    private double value;
    private double conversionMultiple;

    public ExchangeValue()
    {

    }
    public ExchangeValue(Long id, String from, String to,double value)
    {
        this.id = id;
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getValue(){
        return value;
    }
}
