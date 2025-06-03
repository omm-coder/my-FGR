package org.omm.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDTO {


    private String id;
    private List<CartItemDTO> cartItems;

    public CartDTO() {}

    public CartDTO(String id) {
        this.id = id;
        cartItems = new ArrayList<>();
    }


    public void addCartItem(CartItemDTO cartItemDto) {
        this.cartItems.add(cartItemDto);
    }

}
