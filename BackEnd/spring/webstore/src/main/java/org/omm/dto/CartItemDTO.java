package org.omm.dto;


import lombok.Data;

@Data
public class CartItemDTO {

    private String id;
    private String productId;
    private int quantity;

}
