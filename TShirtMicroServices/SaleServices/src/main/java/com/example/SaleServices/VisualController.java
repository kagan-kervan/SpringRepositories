package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visuals")
public class VisualController {

    @Autowired
    private VisualService visualService;

    @GetMapping("/")
    public List<Visual> GetAllImage(){
        return visualService.getAllVisuals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visual> GetImageByID(@PathVariable Long id){
        Visual shirt = visualService.getVisualByID(id);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(shirt);
    }

    @PostMapping("/add")
    public Visual CreateImage(@RequestBody Visual image){
        return visualService.saveVisual(image);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Visual> UpdateImage(@PathVariable Long id, @RequestBody Visual updatedShirt) {
        Visual shirt = visualService.updateVisual(id,updatedShirt);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Visual> DeleteImage(@PathVariable Long id){
        Visual shirt = visualService.deleteVisual(id);
        if (shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }
}
