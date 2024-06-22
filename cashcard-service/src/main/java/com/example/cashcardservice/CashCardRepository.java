package com.example.cashcardservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CashCardRepository extends JpaRepository<CashCard,  Long>
{

}
