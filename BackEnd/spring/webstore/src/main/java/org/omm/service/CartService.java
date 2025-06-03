package org.omm.service;

import org.omm.dto.CartDTO;
import org.omm.model.Cart;

public interface CartService {

    void create(CartDTO cart);
    Cart read(String id);
    int update(String id, CartDTO cart);
    void delete(String id);
    void addItem(String cartId, String productId);
    void removeItem(String cartId, String productId);

    Cart validate(String cartId);
    void clearCart(String cartId);

}
