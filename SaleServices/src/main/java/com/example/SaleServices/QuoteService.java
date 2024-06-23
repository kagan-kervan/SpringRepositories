package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService implements QuoteServiceInterface {
    @Autowired
    private QuoteRepository quoteRepository;
    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote getQuoteByID(Long id) {
        return quoteRepository.findById(id).orElse(null);
    }

    @Override
    public Quote saveQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote updateQuote(Long id, Quote quote) {
        Quote quoteOld = quoteRepository.findById(id).orElse(null);
        if(quoteOld != null){
            quoteOld.setString(quote.getString());
            quoteOld.setOwnerName(quote.getOwnerName());
            quoteRepository.save(quoteOld);
        }
        return quoteOld;
    }

    @Override
    public Quote deleteQuote(Long id) {
        Quote quote = quoteRepository.findById(id).orElse(null);
        if(quote != null)
            quoteRepository.delete(quote);
        return quote;
    }
}
