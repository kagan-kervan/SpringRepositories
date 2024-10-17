package com.example.SaleServices;
import jakarta.persistence.*;
@Entity
public class ShirtString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String font;
    private String size;
    private String fontColour;

    @ManyToOne
    private Quote quote;

    // Constructors, getters, and setters
    public ShirtString() {
    }

    public ShirtString(String font, String size, String fontColour, Quote quote) {
        this.font = font;
        this.size = size;
        this.fontColour = fontColour;
        this.quote = quote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFontColour() {
        return fontColour;
    }

    public void setFontColour(String fontColour) {
        this.fontColour = fontColour;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
