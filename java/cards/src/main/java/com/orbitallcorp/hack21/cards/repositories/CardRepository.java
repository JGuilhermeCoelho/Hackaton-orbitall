package com.orbitallcorp.hack21.cards.repositories;

import com.orbitallcorp.hack21.cards.domains.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CardRepository extends PagingAndSortingRepository<Card, Long>{

    @Query(value = "SELECT c FROM Card c ORDER BY c.embossName")
    List<Card> getCardByEmbossName();

    @Query(value = "SELECT c FROM Card c ORDER BY c.customerName")
    List<Card> getCardByCustomerName();

    @Query(value = "SELECT c FROM Card c ORDER BY c.city")
    List<Card> getCardByCity();

    @Query(value = "SELECT c FROM Card c ORDER BY c.address")
    List<Card> getCardByAddress();

    @Query(value = "SELECT c FROM Card c ORDER BY c.motherName")
    List<Card> getCardByMotherName();

    @Query(value = "SELECT c FROM Card c ORDER BY c.cardNumber")
    List<Card> getCardByCardNumber();

    @Query(value = "SELECT c FROM Card c ORDER BY c.documentNumber")
    List<Card> getCardByDocumentNumber();
}