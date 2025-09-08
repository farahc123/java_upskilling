package com.sparta.fc.northwind.controllers;

import com.sparta.fc.northwind.models.entities.Customer;
import com.sparta.fc.northwind.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // for REST APIs; this anno combines @Controller & @ResponseBody
@RequestMapping("/customers") // maps HTTP request to this endpoint
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @Operation(summary = "Gets all customers", description = "Retrieve a list of all customers")
    @GetMapping(value = "/") // this is a post-fix to @RequestMapping above; maps HTTP GET requests to /customers/
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = service.getAllCustomers();
        return ResponseEntity.ok(customers); // returns OK status
    }

    @Operation(summary = "Get customer by ID", description = "Retrieve a customer from the database by their unique ID")
    // the below may be optional to set up as Spring can do it automatically with starter-data-rest dependency (which also does HATEOAS)
    @GetMapping("/{id}") // arg must match the PV parameter in line below
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Customer customer = service.getCustomerByID(id);
        if(customer != null){
            return ResponseEntity.ok(customer);
        }
        else{
            return ResponseEntity.notFound().build(); // returns 404 not found response
        }
    }

    @Operation(summary = "Add a new customer", description = "Create a new customer in the database")
    @PostMapping // no path needed here as it follows from original mapping above
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) { // this annotation tells Spring to bind the JSON made by the HTTP request to a new Java object
        Customer saveCustomer = service.saveCustomer(customer);
        return ResponseEntity.status(201).body(saveCustomer); // 201 "created" code
    }

    @Operation(summary = "Delete a customer", description = "Deletes a customer by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        Customer customer = service.getCustomerByID(id);
        if (customer != null) {
            service.deleteCustomerById(id); // method I created
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @Operation(summary = "Update a customer", description = "Updates a customer by ID")
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable String id, @RequestBody Customer updatedCustomer) {
        Customer customer = service.getCustomerByID(id);
        if(customer != null){
            customer.setContactName(updatedCustomer.getContactName());
            customer.setCompanyName(updatedCustomer.getCompanyName());
            customer.setContactTitle(updatedCustomer.getContactTitle());
            customer.setAddress(updatedCustomer.getAddress());
            customer.setCity(updatedCustomer.getCity());
            customer.setRegion(updatedCustomer.getRegion());
            customer.setCountry(updatedCustomer.getCountry());
            customer.setPostalCode(updatedCustomer.getPostalCode());
            customer.setPhone(updatedCustomer.getPhone());
            customer.setFax(updatedCustomer.getFax());

            Customer savedCustomer = service.saveCustomer(customer);
            return ResponseEntity.ok(savedCustomer);
        }
        else{
            return ResponseEntity.notFound().build(); // returns 404 not found response
        }
    }

}


