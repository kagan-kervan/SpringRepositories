package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tshirts")
public class TShirtController {

    @Autowired
    private TShirtService shirtService;

    @GetMapping("/")
    public List<TShirt> GetAllTShirts(){
        return shirtService.getAllTShirts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TShirt> GetTshirtByID(@PathVariable Long id){
        TShirt shirt = shirtService.getTShirtByID(id);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(shirt);
    }

    @PostMapping("/add")
    public TShirt CreateTshirt(@RequestBody TShirt tShirt){
        return shirtService.saveTShirt(tShirt);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TShirt> UpdateTShirt(@PathVariable Long id, @RequestBody TShirt updatedShirt) {
        TShirt shirt = shirtService.updateTShirt(id,updatedShirt);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TShirt> DeleteTshirt(@PathVariable Long id){
        TShirt shirt = shirtService.deleteTShirt(id);
        if (shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }
}