package com.matta.matta_springboot.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Column(precision = 8, scale = 6, nullable = false)
    private BigDecimal lat;

    @Column(precision = 9, scale = 6, nullable = false)
    private BigDecimal lng;

    @Builder
    public Address(BigDecimal lat, BigDecimal lng){
        this.lat = lat;
        this.lng = lng;
    }
}
