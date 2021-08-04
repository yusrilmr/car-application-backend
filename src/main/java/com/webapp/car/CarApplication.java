package com.webapp.car;

import com.webapp.car.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CarApplication {
    private static final Logger logger = LoggerFactory.getLogger(CarApplication.class);

    @Autowired
    private CarRepository repository;

    @Autowired
    private OwnerRepository orepository;

    @Autowired
    private UserRepository urepository;

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
        logger.info("Hello Spring Boot");
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            // Add owner objects and save these to db
            Owner owner1 = new Owner("John" , "Johnson");
            Owner owner2 = new Owner("Mary" , "Robinson");
            orepository.saveAll(Arrays.asList(owner1, owner2));

            // Add car object with link to owners and save these to db.
            Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000);
            Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000);
            Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000);
            repository.saveAll(Arrays.asList(car1, car2, car3));

            // add car to the owner
            CarOwner carOwner1 = new CarOwner(car1, owner1);
            CarOwner carOwner2 = new CarOwner(car2, owner1);
            CarOwner carOwner3 = new CarOwner(car2, owner2);
            CarOwner carOwner4 = new CarOwner(car3, owner2);
            carOwnerRepository.saveAll(Arrays.asList(carOwner1, carOwner2, carOwner3, carOwner4));

            // username: user password: user
            urepository.save(new UserEntity("user",
                    "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
                    "USER"));
            // username: admin password: admin
            urepository.save(new UserEntity("admin",
                    "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                    "ADMIN"));
        };
    }
}
