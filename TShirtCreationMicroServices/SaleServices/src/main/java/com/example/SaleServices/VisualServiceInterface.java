package com.example.SaleServices;

import java.util.List;

public interface VisualServiceInterface {
    List<Visual> getAllVisuals();
    Visual getVisualByID(Long id);
    Visual saveVisual(Visual tShirtString);
    Visual updateVisual(Long id, Visual tShirtString);
    Visual deleteVisual(Long id);
}
