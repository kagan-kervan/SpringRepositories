package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tshirt_types")
public class TShirtTypeController {

    @Autowired
    private TShirtTypeService shirtTypeService;

    @GetMapping("/")
    public List<TShirtType> GetAllTShirts(){
        return shirtTypeService.getAllTShirtsTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TShirtType> GetTshirtByID(@PathVariable Long id){
        TShirtType shirt = shirtTypeService.getTShirtTypeByID(id);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(shirt);
    }

    @PostMapping("/add")
    public TShirtType CreateTshirt(@RequestBody TShirtType tShirt){
        return shirtTypeService.saveTShirtType(tShirt);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TShirtType> UpdateTShirt(@PathVariable Long id, @RequestBody TShirtType updatedShirt) {
        TShirtType shirt = shirtTypeService.updateTShirtType(id,updatedShirt);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TShirtType> DeleteTshirt(@PathVariable Long id){
        TShirtType shirt = shirtTypeService.deleteTShirtType(id);
        if (shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }
}
