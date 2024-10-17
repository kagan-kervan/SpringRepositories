package com.example.SaleServices;

import java.util.List;

public interface ImageServiceInterface {
    List<Image> getAllImages();
    Image getImageByID(Long id);
    Image  saveImage(Image image);
    Image updateImage(Long id, Image image);
    Image deleteImage(Long id);
}
