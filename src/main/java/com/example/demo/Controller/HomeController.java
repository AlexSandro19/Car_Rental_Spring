package com.example.demo.Controller;

import com.example.demo.Model.Car;
import com.example.demo.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Model.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CarService carService;

    @GetMapping("/")
    public String index(){
        return "home/index";
    }
    

    @GetMapping("/carMenu")
    public String carMenu(Model model){
        List<Car> carList = carService.fetchAll();
        model.addAttribute("cars", carList);
        return "home/carMenu";
    }

    @GetMapping("/viewCar/{car_id}")
    public String viewCar(@PathVariable("car_id") int car_id, Model model){
        model.addAttribute("carComplete", carService.findCarById(car_id));
        return "home/viewCar";
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
        return "redirect:/";
    }

}
