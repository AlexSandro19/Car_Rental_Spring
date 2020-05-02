package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String customers(Model model){
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers", customerList);
        return "home/customers";
    }

    @GetMapping("/add_customer")
    public String add_customer(){
        return "/home/add_customer";
    }

    @PostMapping("/add_customer")
    public String add_customer(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        return "redirect:customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        boolean deleted = customerService.deleteCustomer(id);
        if (deleted) {
            return "redirect:customers";
        }
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "/home/update_customer";
    }
    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer.getCustomer_id(), customer);
        return "redirect:customers";
    }


}
