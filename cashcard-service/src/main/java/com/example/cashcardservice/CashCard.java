package com.example.cashcardservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Random;

@Entity
public class CashCard
{
    private @Id @GeneratedValue Long id;
    private int cvv_num;
    private double amount;

    private String giver;

   /* private CashCardUser giverCashCardUser;
    private CashCardUser receiverCashCardUser;
    */

    public CashCard(){}
    public CashCard(double amount,String giver)
    {
        this.amount = amount;
        cvv_num = GenerateCVV();
        this.giver = giver;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCvv_num() {
        return cvv_num;
    }

    public void setCvv_num(int cvv_num) {
        this.cvv_num = cvv_num;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getGiver() {
        return giver;
    }

    public void setGiver(String giver) {
        this.giver = giver;
    }

    private int GenerateCVV()
    {
        //Generates a 3 digit CVV number.
        Random r = new Random();
        return r.nextInt(100,999);
    }

    @Override
    public String toString(){
        return "ID: "+id+"\nCVV: "+cvv_num+"\nBalance: "+amount+"\nGiver: "+giver;
    }
}
