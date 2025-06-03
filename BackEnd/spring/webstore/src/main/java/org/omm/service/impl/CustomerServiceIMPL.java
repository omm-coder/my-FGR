package org.omm.service.impl;

import org.omm.dao.impl.CustomerDAOIMPL;
import org.omm.model.Customer;
import org.omm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerDAOIMPL customerDAOIMPL;
    @Override
    public Optional<Customer> getCustomer(String customerId) {
        return customerDAOIMPL.getCustomer(customerId);
    }

    @Override
    public Boolean isCustomerExist(String customerId) {
        return customerDAOIMPL.isCustomerExist(customerId);
    }
}
