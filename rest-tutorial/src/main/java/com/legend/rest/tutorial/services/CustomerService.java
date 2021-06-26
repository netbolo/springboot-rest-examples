package com.legend.rest.tutorial.services;

import java.util.List;

import com.legend.rest.tutorial.persistence.model.Customer;

public interface CustomerService {

    List<Customer> allCustomers();

    Customer getCustomerDetail(final String id);

}
