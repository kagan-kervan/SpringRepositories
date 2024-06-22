package com.example.SaleServices;
import jakarta.persistence.*;

@Entity
public class TShirtType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shape;

    @ManyToOne
    private ShirtString frontString;

    @ManyToOne
    private ShirtString backString;

    @ManyToOne
    private Visual visual;

    // Constructors, getters, and setters
    public TShirtType() {
    }

    public TShirtType(String shape, ShirtString frontString, ShirtString backString, Visual visual) {
        this.shape = shape;
        this.frontString = frontString;
        this.backString = backString;
        this.visual = visual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public ShirtString getFrontString() {
        return frontString;
    }

    public void setFrontString(ShirtString frontString) {
        this.frontString = frontString;
    }

    public ShirtString getBackString() {
        return backString;
    }

    public void setBackString(ShirtString backString) {
        this.backString = backString;
    }

    public Visual getVisual() {
        return visual;
    }

    public void setVisual(Visual visual) {
        this.visual = visual;
    }
}
