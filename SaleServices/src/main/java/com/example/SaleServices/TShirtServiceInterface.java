package com.example.SaleServices;

import java.util.List;

public interface TShirtServiceInterface {
    List<TShirt> getAllTShirts();
    TShirt getTShirtByID(Long id);
    TShirt saveTShirt(TShirt tshirt);
    TShirt updateTShirt(Long id, TShirt tshirt);
    TShirt deleteTShirt(Long id);
}