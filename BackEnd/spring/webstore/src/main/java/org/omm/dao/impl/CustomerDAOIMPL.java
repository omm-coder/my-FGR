package org.omm.dao.impl;

import org.omm.dao.CustomerDAO;
import org.omm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class CustomerDAOIMPL implements CustomerDAO {

    @Autowired
    private NamedParameterJdbcTemplate np_jdbc_template;


    @Override
    public Optional<Customer> getCustomer(String customerId) {
        String sql = "select * from customer where id = :id";

        Map<String, String> params = new HashMap<>();
        params.put("id",customerId);
        return Optional.ofNullable(np_jdbc_template.queryForObject(sql, params,
                new BeanPropertyRowMapper<>(Customer.class)));
    }

    @Override
    public Boolean isCustomerExist(String customerId) {
        Optional<Customer> customer = getCustomer(customerId);
        if (customer.isPresent())
            if (customer.get().getCustomerId().equals(customer)) {
                System.out.println("customer already exist!");
                return true;
            }
        return false;
    }
}
