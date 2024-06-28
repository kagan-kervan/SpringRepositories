package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shirt_strings")
public class ShirtStringController {

    @Autowired
    private ShirtStringService stringService;

    @GetMapping("/")
    public List<ShirtString> GetAllQuote(){
        return stringService.getAllStrings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShirtString> GetQuoteByID(@PathVariable Long id){
        ShirtString shirt = stringService.getTShirtStringByID(id);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(shirt);
    }

    @PostMapping("/add")
    public ShirtString CreateQuote(@RequestBody ShirtString string){
        return stringService.saveString(string);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ShirtString> UpdateQuote(@PathVariable Long id, @RequestBody ShirtString updatedShirt) {
        ShirtString shirt = stringService.updateString(id,updatedShirt);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ShirtString> DeleteQuote(@PathVariable Long id){
        ShirtString shirt = stringService.deleteString(id);
        if (shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }
}
