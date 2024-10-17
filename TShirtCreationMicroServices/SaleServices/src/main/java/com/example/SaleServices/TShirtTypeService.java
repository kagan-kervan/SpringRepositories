package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtTypeService implements TShirtTypeInterface{
    @Autowired
    private TShirtTypeRepository shirtTypeRepository;
    @Override
    public List<TShirtType> getAllTShirtsTypes() {
        return shirtTypeRepository.findAll();
    }

    @Override
    public TShirtType getTShirtTypeByID(Long id) {
        return shirtTypeRepository.findById(id).orElse(null);
    }

    @Override
    public TShirtType saveTShirtType(TShirtType tShirtType) {
        return shirtTypeRepository.save(tShirtType);
    }

    @Override
    public TShirtType updateTShirtType(Long id, TShirtType tShirtType) {
        TShirtType shirtType = shirtTypeRepository.findById(id).orElse(null);
        if(shirtType!=null){
            shirtType.setBackString(tShirtType.getBackString());
            shirtType.setFrontString(tShirtType.getFrontString());
            shirtType.setShape(tShirtType.getShape());
            shirtType.setVisual(tShirtType.getVisual());
            shirtTypeRepository.save(shirtType);
        }
        return shirtType;
    }

    @Override
    public TShirtType deleteTShirtType(Long id) {
        TShirtType shirtType = shirtTypeRepository.findById(id).orElse(null);
        if(shirtType != null)
            shirtTypeRepository.delete(shirtType);
        return shirtType;
    }
}
