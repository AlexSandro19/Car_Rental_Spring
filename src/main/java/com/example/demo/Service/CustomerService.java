package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> fetchAll(){
        return customerRepo.fetchAll();
    }

    public Customer addCustomer(Customer c){
        return customerRepo.addCustomer(c);
    }

    public boolean deleteCustomer(int id){
        return customerRepo.deleteCustomer(id);
    }

    public Customer updateCustomer(int id, Customer c){
        return customerRepo.updateCustomer(id, c);
    }

    public Customer findCustomerById(int id){
        return customerRepo.findCustomerById(id);
    }
}
