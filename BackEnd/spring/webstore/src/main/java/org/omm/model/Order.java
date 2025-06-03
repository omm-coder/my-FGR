package org.omm.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private Long orderId;
    private Cart cart;
    private Customer customer;
    private ShippingDetail shippingDetail;

    public Order() {
        this.customer = new Customer();
        this.shippingDetail = new ShippingDetail();
    }


}
