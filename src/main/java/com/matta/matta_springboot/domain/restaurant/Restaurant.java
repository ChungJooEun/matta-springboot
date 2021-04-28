package com.matta.matta_springboot.domain.restaurant;

import com.matta.matta_springboot.domain.address.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESTAURANT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Column(nullable = false)
    private String name;

    @Builder
    public Restaurant(Long id, Address address, String name){
        this.id = id;
        this.address = address;
        this.name = name;
    }
}
