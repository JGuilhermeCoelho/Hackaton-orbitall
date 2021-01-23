package com.orbitallcorp.hack21.cards.controllers;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> save(@RequestBody Card card) {
        Card savedCard = cardService.save((card));

        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Card>> findAll() {
        List<Card> allCards = cardService.findAll();

        return new ResponseEntity<>(allCards, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCard(@PathVariable("id") Long id,  @RequestBody Card card) {
        Card cardAux = cardService.findById(id);

        if (card.getCardNumber() != null) {
            cardAux.setCardNumber(card.getCardNumber());
        }

        if (card.getEmbossName() != null) {
            cardAux.setEmbossName(card.getEmbossName());
        }

        if (card.getCustomerName() != null) {
            cardAux.setCustomerName(card.getCustomerName());
        }

        if (card.getDocumentNumber() != null) {
            cardAux.setDocumentNumber(card.getDocumentNumber());
        }

        if (card.getMotherName() != null) {
            cardAux.setMotherName(card.getMotherName());
        }

        if (card.getAddress() != null) {
            cardAux.setAddress(card.getAddress());
        }

        if (card.getCity() != null) {
            cardAux.setCity(card.getCity());
        }

        cardService.updateCard(cardAux);
        return new ResponseEntity<>(cardAux, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Card> deleteCard(@PathVariable("id") Long id) {
        Card cardAux = cardService.findById(id);

        cardService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCard(@PathVariable("id") Long id) {
        try {
            Card cardAux = cardService.findById(id);

            return new ResponseEntity<Card>(cardAux, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Error("Card with id " + id + " not found"),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/paginationAndSorting")
    public ResponseEntity<List<Card>> findAndSort(String order) {
        List<Card> allCards = cardService.findAndSort(order);

        return new ResponseEntity<>(allCards, HttpStatus.OK);
    }

}
