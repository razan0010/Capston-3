package com.example.personalshoppersystem.Repository;

import com.example.personalshoppersystem.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findCustomerById(Integer id);
    Customer getCustomerByUsername(String username);
    List<Customer> getCustomerByCity(String city);

}
