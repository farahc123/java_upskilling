package com.sparta.fc.northwind;

import com.sparta.fc.northwind.models.entities.Customer;
import com.sparta.fc.northwind.repositories.CustomerRepository;
import com.sparta.fc.northwind.services.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class NorthwindApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(NorthwindApplication.class, args); // this runs the app and stores all its beans here
//
//        CustomerRepository customerRepository = context.getBean(CustomerRepository.class); // a concrete implementation of this interface is created on running the app and stored in this variable at runtime
//
//        List<Customer> customers = customerRepository.findAll();
//
//        for(Customer customer : customers) {
//            System.out.println(customer);
//        }

        CustomerService customerService = context.getBean(CustomerService.class);

        // creating new customer object
        Customer fc = new Customer();
        fc.setCustomerID("AAAAA");
        fc.setCompanyName("Sparta Global");
        fc.setContactName("Farah Cheded");

        // savign it to the DB
        customerService.saveCustomer(fc);
        // printing it via getCustomerByID method
        System.out.println(customerService.getCustomerByID("AAAAA"));

        // updating it
        fc.setContactName("Farah C");
        customerService.updateCustomer(fc);

//        // customerService.deleteCustomerById("AAAAA");
//
//        // customerService.deleteCustomerById("fc"); // this won't work as the ID provided doesn't exist

        List<Customer> customers = customerService.getAllCustomers();
        for(Customer x : customers){
            System.out.println(x);
        }

    }

}
