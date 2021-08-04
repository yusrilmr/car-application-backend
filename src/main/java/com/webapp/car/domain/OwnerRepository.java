package com.webapp.car.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    // Fetch cars by brand
    List<Owner> findByFirstname(String firstname);
}
