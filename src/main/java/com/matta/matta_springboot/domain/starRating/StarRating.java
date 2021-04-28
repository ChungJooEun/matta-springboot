package com.matta.matta_springboot.domain.starRating;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class StarRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STARRATING_ID")
    private Long id;

    @Column(nullable = false)
    private int moodRating;

    @Column(nullable = false)
    private int tasteRating;

    @Column(nullable = false)
    private int priceRating;

    @Builder
    public StarRating(int moodRating, int tasteRating, int priceRating){
        this.moodRating = moodRating;
        this.tasteRating = tasteRating;
        this.priceRating = priceRating;
    }

    public StarRating update(int moodRating, int tasteRating, int priceRating){
        this.moodRating = moodRating;
        this.tasteRating = tasteRating;
        this.priceRating = priceRating;

        return this;
    }

}
