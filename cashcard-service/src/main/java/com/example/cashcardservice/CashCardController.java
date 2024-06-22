package com.example.cashcardservice;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CashCardController
{
    private final CashCardRepository cashCardRepository;

    public CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }
    @GetMapping("/cards")
    List<CashCard> All()
    {
        return cashCardRepository.findAll();
    }
    @PostMapping("/cards")
    CashCard NewCashCard(@RequestBody CashCard card){
        return cashCardRepository.save(card);
    }

    @GetMapping("/cards/{id}")
    CashCard FindOne(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {

        return cashCardRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }
    @PutMapping("/cards/{id}")
    CashCard UpdateCashCard(@RequestBody CashCard card, @PathVariable Long id){
        return cashCardRepository.findById(id)
                //if finds, updates the amount and giver str.
                .map(card1 -> {
                    card1.setAmount(card.getAmount());
                    card1.setGiver(card.getGiver());
                    return cashCardRepository.save(card1);
                    //If it doesn't find, it adds to the database.
                }).orElseGet(()-> {
                            card.setId(id);
                            return cashCardRepository.save(card);
                        }
                );
    }
    @DeleteMapping("/cards/{id}")
    void deleteCard(@PathVariable Long id) {
        cashCardRepository.deleteById(id);
    }
}



