package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements ImageServiceInterface {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image getImageByID(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image updateImage(Long id, Image image) {
        Image imageOld = imageRepository.findById(id).orElse(null);
        if(imageOld != null){
            imageOld.setUrl(image.getUrl());
            imageRepository.save(imageOld);
        }
        return imageOld;
    }

    @Override
    public Image deleteImage(Long id) {
       Image image = imageRepository.findById(id).orElse(null);
       if (image != null)
           imageRepository.delete(image);
       return image;
    }
}
