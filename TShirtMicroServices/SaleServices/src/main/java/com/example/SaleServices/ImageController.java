package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public List<Image> GetAllImage(){
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> GetImageByID(@PathVariable Long id){
        Image shirt = imageService.getImageByID(id);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(shirt);
    }

    @PostMapping("/add")
    public Image CreateImage(@RequestBody Image image){
        return imageService.saveImage(image);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Image> UpdateImage(@PathVariable Long id, @RequestBody Image updatedShirt) {
        Image shirt = imageService.updateImage(id,updatedShirt);
        if(shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Image> DeleteImage(@PathVariable Long id){
        Image shirt = imageService.deleteImage(id);
        if (shirt == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shirt);
    }
}
