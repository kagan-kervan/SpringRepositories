package com.example.SaleServices;

import java.util.List;

public interface TShirtTypeInterface {
    List<TShirtType> getAllTShirtsTypes();
    TShirtType getTShirtTypeByID(Long id);
    TShirtType saveTShirtType(TShirtType tShirtType);
    TShirtType updateTShirtType(Long id, TShirtType tShirtType);
    TShirtType deleteTShirtType(Long id);
}
