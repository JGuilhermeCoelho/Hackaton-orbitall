package com.orbitallcorp.hack21.cards.services;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save((card));
    }

    public List<Card> findAll() {
        List<Card> cards = new ArrayList<>();
        cardRepository.findAll().forEach(cards :: add);

        return cards;
    }

    public void updateCard(Card card) {
        cardRepository.save(card);
    }

    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }

    public Card findById(Long id) {
        return cardRepository.findById(id).get();
    }

    public List<Card> findAndSort(String order) {
        List<Card> cards = new ArrayList<>();

        if (order == null) {
            order = "";
        }
        if (order.equals("embossName")) {
            cardRepository.getCardByEmbossName().forEach(cards::add);
        } else if (order.equals("customerName")) {
            cardRepository.getCardByCustomerName().forEach(cards :: add);
        } else if (order.equals("address")) {
            cardRepository.getCardByAddress().forEach(cards :: add);
        } else if (order.equals("city")) {
            cardRepository.getCardByCity().forEach(cards :: add);
        } else if (order.equals("documentNumber")) {
            cardRepository.getCardByDocumentNumber().forEach(cards :: add);
        } else if (order.equals("motherName")) {
            cardRepository.getCardByMotherName().forEach(cards :: add);
        } else if (order.equals("cardNumber")) {
            cardRepository.getCardByCardNumber().forEach(cards :: add);
        } else {
            cardRepository.findAll().forEach(cards :: add);
        }
        return cards;
    }

}
