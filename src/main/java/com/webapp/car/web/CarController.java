//package com.webapp.car.web;
//
//import com.webapp.car.domain.Car;
//import com.webapp.car.domain.CarRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class CarController {
//    @Autowired
//    private CarRepository repository;
//
//    @RequestMapping("/cars")
//    public Iterable<Car> getCars() {
//        return repository.findAll();
//    }
//}
