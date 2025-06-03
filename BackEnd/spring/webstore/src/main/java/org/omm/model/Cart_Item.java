package org.omm.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Cart_Item implements Serializable {

    private String id;
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public Cart_Item(String id) {
        super();
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        this.updateTotalPrice();
        return totalPrice;
    }

    public void updateTotalPrice() {
        totalPrice =
                this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }


}
