package org.omm.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {

    private Long customerId;
    private String name;
    private Address billingAddress;
    private String phoneNumber;


    public Customer() {
        super();
        this.billingAddress = new Address();
    }

    public Customer(Long customerId, String name) {
        this();
        this.customerId = customerId;
        this.name = name;
    }



}
