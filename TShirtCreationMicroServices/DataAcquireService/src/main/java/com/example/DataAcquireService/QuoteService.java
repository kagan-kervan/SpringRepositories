package com.example.DataAcquireService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteService {
    private String API_key = "cd2c2d3227abd5e89b8c98fc4fd78055";
    private final String apiUrl = "https://favqs.com/api/quotes/";
    private final String kanyeAPIURL = "https://api.kanye.rest/";

    public String getKanyeQuote(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(kanyeAPIURL,HttpMethod.GET,null,String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(response.getBody());
                String quoteText = root.path("quote").asText();
                return quoteText;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getQuotes() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token token=\"" + API_key + "\"");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(root);
    }
}
