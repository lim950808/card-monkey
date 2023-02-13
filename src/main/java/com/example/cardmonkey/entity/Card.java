package com.example.cardmonkey.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Card {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    private String name;
    private String company;
    private String imageURL;
    private String applyURL;
    private int lastMonthPaid;
    private int annualFee;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Embedded
    private Benefit benefit;

    @OneToMany(mappedBy = "card")
    private List<Review> reviews = new ArrayList<>();
}