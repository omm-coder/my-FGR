package org.omm.dao;

import org.omm.model.Customer;

import java.util.Optional;

public interface CustomerDAO {

//    void saveCustomer(Customer customer);
    Optional<Customer> getCustomer(String customerId);
    Boolean isCustomerExist(String customerId);

}
