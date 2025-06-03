package org.omm.service;

import org.omm.model.Customer;

import java.util.Optional;

public interface CustomerService {

    public Optional<Customer> getCustomer(String customerId);
    public Boolean isCustomerExist(String customerId);

}
