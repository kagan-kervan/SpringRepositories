package com.example.SaleServices;

import java.util.List;

public interface ShirtStringServiceInterface {
    List<ShirtString> getAllStrings();
    ShirtString getTShirtStringByID(Long id);
    ShirtString saveString(ShirtString tShirtString);
    ShirtString updateString(Long id, ShirtString tShirtString);
    ShirtString deleteString(Long id);
}
