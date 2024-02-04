package com.example.carbackend.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String brand;

    String model;

    String color;

    String registrationNumber;

    Integer modelYear;

    Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    Owner owner;

    public Car() {

    }

    public Car(String brand, String model, String color, String registrationNumber,
               Integer modelYear, Integer price, Owner owner) {
        super();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.owner = owner;
    }
}
