package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

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
    public List<Quote> GetQuoteFromPublicAPI(){
        return quoteService.AcquireQuotesFromPublicAPI();
    }
    @GetMapping("/get/from/kanye")
    public Quote GetQuoteFromKanyeAPI(){
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
