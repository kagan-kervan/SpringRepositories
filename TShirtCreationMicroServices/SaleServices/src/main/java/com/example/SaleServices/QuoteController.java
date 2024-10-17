package com.example.SaleServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/get")
    public List<Quote> GetAllQuote(){
        return quoteService.getAllQuotes();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Quote> GetQuoteByID(@PathVariable Long id){
        Quote shirt = quoteService.getQuoteByID(id);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(shirt);
    }

    @GetMapping("/get/from/public")
    public List<Quote> GetQuoteFromPublicAPI(@RequestParam String username, @RequestParam String password){
        String url = "http://localhost:8085/api/signin?username="+username+"&password="+password;
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                null,
                String.class
        );
        if(response.getStatusCode() != HttpStatus.OK)
            return null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            JsonNode root = mapper.readTree(response.getBody());
            String role = String.valueOf(root.path("role"));
            role = role.substring(1,role.length()-1);
            if(!role.equals("ADMIN"))
                return null; //Unauthorized
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return quoteService.AcquireQuotesFromPublicAPI();
    }
    @GetMapping("/get/from/kanye")
    public Quote GetQuoteFromKanyeAPI(@RequestParam String username, @RequestParam String password){
        String url = "http://localhost:8085/api/signin?username="+username+"&password="+password;
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                null,
                String.class
        );
        if(response.getStatusCode() != HttpStatus.OK)
            return null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            JsonNode root = mapper.readTree(response.getBody());
            String role = String.valueOf(root.path("role"));
            role = role.substring(1,role.length()-1);
            if(!role.equals("ADMIN"))
                return null; //Unauthorized
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return quoteService.AcquireQuoteFromKanye();
    }
    @PostMapping("/add")
    public Quote CreateQuote(@RequestBody Quote quote){
        return quoteService.saveQuote(quote);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Quote> UpdateQuote(@PathVariable Long id, @RequestBody Quote updatedShirt) {
        Quote shirt = quoteService.updateQuote(id,updatedShirt);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Quote> DeleteQuote(@PathVariable Long id){
        Quote shirt = quoteService.deleteQuote(id);
        if (shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }
}
