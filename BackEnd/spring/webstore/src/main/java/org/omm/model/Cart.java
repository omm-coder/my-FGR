package org.omm.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Data
public class Cart implements Serializable {

    private String id;
    private List<Cart_Item> cartItems;
    private BigDecimal grandTotal;

    public Cart(String id) {
        this.id = id;
    }

    public Optional<Cart_Item> getItemByProductId(String
                                               productId) {
        return cartItems.stream()
                .filter(cartItem ->
                        cartItem.getProduct().getProductId()
                                .equals(productId))
                .findAny();
    }
    public void updateGrandTotal() {
        Function<Cart_Item, BigDecimal> totalMapper = Cart_Item::getTotalPrice;
        BigDecimal grandTotal = cartItems.stream()
                .map(totalMapper)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        this.setGrandTotal(grandTotal);
    }




}
