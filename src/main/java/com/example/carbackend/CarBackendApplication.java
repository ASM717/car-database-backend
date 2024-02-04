package com.example.carbackend;


import com.example.carbackend.model.Car;
import com.example.carbackend.model.Owner;
import com.example.carbackend.repository.CarRepository;
import com.example.carbackend.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class CarBackendApplication implements CommandLineRunner {

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    public CarBackendApplication(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CarBackendApplication.class, args);
        log.info("Application start (<!>)");
    }


    @Override
    public void run(String... args) {

        // Add owner objects and save these to db
        Owner owner1 = new Owner("John" , "Johnson");
        Owner owner2 = new Owner("Mary" , "Robinson");
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
        carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
        carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner2));
        // Fetch all cars and log to console
        for (Car car : carRepository.findAll()) {
            log.info("brand: {}, model: {}", car.getBrand(), car.getModel());
        }
    }
}
