package com.dao;

import java.util.List;

import com.entity.Customer;

public interface CustomerDAO {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);
    
  public Customer searchCustomer(int theMobile);

    public void deleteCustomer(int theId);

	//List<Customer> searchCustomer();
}
