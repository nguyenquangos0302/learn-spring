package com.example.demo.service.impl;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.model.SecurityCustomer;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<CustomerEntity> customer = customerRepository.findByEmail(email);
        if (customer.isPresent()) {
            return new SecurityCustomer(customer.get());
        } else {
            throw new UsernameNotFoundException("User not found: " + email);
        }
    }
}
