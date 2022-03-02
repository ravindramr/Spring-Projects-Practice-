package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Customer;
import com.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController { 

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String listCustomers(Model theModel) {
    	System.out.println("In list customers method");
        List < Customer > theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
    	System.out.println("In show form method");
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }
    
   @GetMapping("/search")
    public String showFormForSearch(@RequestParam("customerMob") int theMobile,
        Model theModel) {
    	System.out.println("in search method");
       // int theMobile = 0;
		Customer theCustomer = customerService.getCustomer(theMobile);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

 @RequestMapping(value = "/saveCustomer",method = RequestMethod.POST)
  //  @PostMapping("/saveCustomer")
 
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
	 System.out.println("In save customers method");
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
        Model theModel) {
    	System.out.println("in update method");
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
    	System.out.println("in delete method");
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
}
