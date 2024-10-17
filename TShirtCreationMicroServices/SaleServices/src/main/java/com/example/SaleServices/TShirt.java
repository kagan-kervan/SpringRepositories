package com.example.SaleServices;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.aspectj.util.GenericSignature;

@Entity
public class TShirt
{
    private @Id @GeneratedValue Long id;
    private int Quantity;
    private String Size;
    private double Price;

    @ManyToOne
    private TShirtType tshirtType;

    TShirt() {}
    TShirt(int quantity,String size,double price, TShirtType tShirtType){
        Quantity = quantity;
        Size = size;
        Price = price;
        this.tshirtType = tShirtType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public TShirtType getTshirtType() {
        return tshirtType;
    }

    public void setTshirtType(TShirtType tshirtType) {
        this.tshirtType = tshirtType;
    }
}
