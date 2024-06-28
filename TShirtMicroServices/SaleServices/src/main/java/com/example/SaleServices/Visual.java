package com.example.SaleServices;
import jakarta.persistence.*;

@Entity
public class Visual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String firstColour;
    private String secondColour;

    @ManyToOne
    private Image image;

    // Constructors, getters, and setters
    public Visual() {
    }

    public Visual(String type, String firstColour, String secondColour, Image image) {
        this.type = type;
        this.firstColour = firstColour;
        this.secondColour = secondColour;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstColour() {
        return firstColour;
    }

    public void setFirstColour(String firstColour) {
        this.firstColour = firstColour;
    }

    public String getSecondColour() {
        return secondColour;
    }

    public void setSecondColour(String secondColour) {
        this.secondColour = secondColour;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
