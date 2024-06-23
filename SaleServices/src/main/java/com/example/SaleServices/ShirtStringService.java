package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShirtStringService implements ShirtStringServiceInterface{
    @Autowired
    private ShirtStringRepository stringRepository;
    @Override
    public List<ShirtString> getAllStrings() {
        return stringRepository.findAll();
    }

    @Override
    public ShirtString getTShirtStringByID(Long id) {
        return stringRepository.findById(id).orElse(null);
    }

    @Override
    public ShirtString saveString(ShirtString tShirtString) {
        return stringRepository.save(tShirtString);
    }

    @Override
    public ShirtString updateString(Long id, ShirtString tShirtString) {
        ShirtString string = stringRepository.findById(id).orElse(null);
        if(string != null){
            string.setFont(tShirtString.getFont());
            string.setSize(tShirtString.getSize());
            string.setFontColour(tShirtString.getFontColour());
            string.setQuote(tShirtString.getQuote());
            stringRepository.save(string);
        }
        return string;
    }

    @Override
    public ShirtString deleteString(Long id) {
        ShirtString string = stringRepository.findById(id).orElse(null);
        if(string != null)
            stringRepository.delete(string);
        return string;
    }
}
