package com.example.demo.Repository;


import com.example.demo.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate template;

    public List<Customer> fetchAll(){
        String sql = "SELECT * FROM customers;";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    public Customer addCustomer(Customer c){
        String sql="INSERT INTO customers (first_name, last_name, st_address, zip, mobile_phone, addit_phone, email, driver_license, driver_since) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?)";
        template.update(sql, c.getFirst_name(), c.getLast_name(), c.getSt_address(), c.getZip(), c.getMobile_phone(), c.getAddit_phone(), c.getEmail(), c.getDriver_license(), c.getDriver_since());
        return null;
    }

    public Customer findCustomerById(int id){
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer c = template.queryForObject(sql, rowMapper, id);
        return c;
    }

    public Boolean deleteCustomer(int id){
        String sql = "DELETE FROM customers WHERE customer_id = ?";
        return template.update(sql, id) < 0;
    }

    public Customer updateCustomer(int id, Customer c){
        String sql = "UPDATE customers SET first_name = ?, last_name = ?, st_address = ?, zip = ?, mobile_phone = ?, addit_phone = ?, email = ?, driver_license = ?, driver_since = ? WHERE customer_id = ?";
        template.update(sql, c.getFirst_name(), c.getLast_name(), c.getSt_address(), c.getZip(), c.getMobile_phone(), c.getAddit_phone(), c.getEmail(), c.getDriver_license(), c.getDriver_since(), c.getCustomer_id());
        return null;
    }
}
