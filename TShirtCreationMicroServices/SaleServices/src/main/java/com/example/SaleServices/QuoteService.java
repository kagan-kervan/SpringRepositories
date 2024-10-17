package com.example.SaleServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteService implements QuoteServiceInterface {
    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    private RestTemplate restTemplate;

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

    @Override
    public List<Quote> AcquireQuotesFromPublicAPI() {
        List<Quote> quotes = new ArrayList<Quote>();
        String url = "http://localhost:8081/quotes";
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        );
        if(response.getStatusCode() != HttpStatus.OK)
            return null;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
            JsonNode quotesArray = root.path("quotes");
            for (JsonNode quoteNode : quotesArray) {
                String quoteText = quoteNode.path("body").asText();
                String quoteOwner = quoteNode.path("author").asText();
                Quote quote = new Quote(quoteText, quoteOwner);
                quotes.add(quote);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < quotes.size(); i++) {
            quoteRepository.save(quotes.get(i));
        }
        return quotes;
    }

    @Override
    public Quote AcquireQuoteFromKanye() {
        String url = "http://localhost:8081/quotes/from/kanye";
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        );
        if(response.getStatusCode() != HttpStatus.OK)
            return null;
            String str = response.getBody();
            Quote newQuote = new Quote(str,"Kanye West");
            quoteRepository.save(newQuote);
            return newQuote;

    }
}
