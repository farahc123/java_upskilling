package com.sparta.fc.northwind.repositories;

import com.sparta.fc.northwind.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// this interface is needed to talk to the database

 @RepositoryRestResource(exported = false) // this disables automatic exposing of all endpoints (so only those explicitly created will be exposed)
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
