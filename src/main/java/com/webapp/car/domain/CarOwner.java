package com.webapp.car.domain;

import javax.persistence.*;

@Entity
public class CarOwner {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public CarOwner(){}
    public CarOwner(Car car, Owner owner) {
        super();
        this.car = car;
        this.owner = owner;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
