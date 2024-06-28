package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtService implements TShirtServiceInterface {

    @Autowired
    private TShirtRepository tShirtRepository;
    @Override
    public List<TShirt> getAllTShirts(){
        return tShirtRepository.findAll();
    }
    @Override
    public TShirt getTShirtByID(Long id){
        return tShirtRepository.findById(id).orElse(null);
    }


    @Override
    public TShirt saveTShirt(TShirt tShirt){
        return tShirtRepository.save(tShirt);
    }
    @Override
    public TShirt deleteTShirt(Long id){
        TShirt shirt = tShirtRepository.findById(id).orElse(null);
        if(shirt != null){
            tShirtRepository.delete(shirt);
        }
        return shirt;
    }
    @Override
    public TShirt updateTShirt(Long id, TShirt tshirtDetails) {
        TShirt tshirt = getTShirtByID(id);
        if (tshirt != null) {
            tshirt.setQuantity(tshirtDetails.getQuantity());
            tshirt.setSize(tshirtDetails.getSize());
            tshirt.setPrice(tshirtDetails.getPrice());
            tshirt.setTshirtType(tshirtDetails.getTshirtType());
            return tShirtRepository.save(tshirt);
        } else {
            return null;
        }
    }


}
