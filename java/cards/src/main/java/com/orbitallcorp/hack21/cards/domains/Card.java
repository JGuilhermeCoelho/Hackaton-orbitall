package com.orbitallcorp.hack21.cards.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Defini como tipo String pois caso o carNumber inicie com 0 não haja problema
    private String cardNumber;
    private String embossName ;
    private String customerName;
    // Defini como tipo String pois caso o documento seja um CPF, permite o inicio com 0
    private String documentNumber;
    private String motherName;
    private String address;
    private String city;

}
