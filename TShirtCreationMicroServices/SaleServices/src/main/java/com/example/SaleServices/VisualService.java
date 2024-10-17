package com.example.SaleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualService implements VisualServiceInterface{
    @Autowired
    private VisualRepository visualRepository;
    @Override
    public List<Visual> getAllVisuals() {
        return visualRepository.findAll();
    }

    @Override
    public Visual getVisualByID(Long id) {
        return visualRepository.findById(id).orElse(null);
    }

    @Override
    public Visual saveVisual(Visual visual) {
        return visualRepository.save(visual);
    }

    @Override
    public Visual updateVisual(Long id, Visual visual) {
        Visual visualOld = visualRepository.findById(id).orElse(null);
        if(visualOld != null){
            visualOld.setFirstColour(visual.getFirstColour());
            visualOld.setImage(visual.getImage());
            visualOld.setType(visual.getType());
            visualOld.setSecondColour(visual.getSecondColour());
            visualRepository.save(visualOld);
        }
        return visualOld;
    }

    @Override
    public Visual deleteVisual(Long id) {
        Visual visual = visualRepository.findById(id).orElse(null);
        if(visual != null)
            visualRepository.delete(visual);
        return visual;
    }
}
