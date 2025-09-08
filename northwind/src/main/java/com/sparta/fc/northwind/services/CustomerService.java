package com.sparta.fc.northwind.services;

import com.sparta.fc.northwind.models.entities.Customer;
import org.springframework.stereotype.Service;
import com.sparta.fc.northwind.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByID(String id){
        if(id.length()>5){
            throw new IllegalArgumentException("Can't have ID longer than 5 characters");
        }else{
            return customerRepository.findById(id).orElse(null);
        }
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer){ // better example below
        customerRepository.delete(customer);
    }

    public void deleteCustomerById(String id){
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException("Customer with ID " + id + " does not exist");
        }
    }

    public Customer updateCustomer(Customer customer){
        if (customer == null || customer.getCustomerID() == null) {
            throw new IllegalArgumentException("Customer or Customer ID must not be null");
        }
        if (!customerRepository.existsById(customer.getCustomerID())) {
            throw new IllegalArgumentException("Customer with ID " + customer.getCustomerID() + " does not exist");
        }
        return customerRepository.save(customer);
    }
    }


