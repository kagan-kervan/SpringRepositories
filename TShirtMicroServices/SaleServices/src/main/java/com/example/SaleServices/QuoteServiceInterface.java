package com.example.SaleServices;

import java.util.List;

public interface QuoteServiceInterface {
    List<Quote> getAllQuotes();
    Quote getQuoteByID(Long id);
    Quote saveQuote(Quote quote);
    Quote updateQuote(Long id, Quote quote);
    Quote deleteQuote(Long id);
}
