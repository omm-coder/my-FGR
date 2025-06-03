package org.omm.dao;

import org.omm.dto.CartDTO;
import org.omm.model.Cart;

public interface CartDAO {

    void create(CartDTO CartDTO);
    Cart read(String id);
    int update(String id, CartDTO CartDTO);
    void delete(String id);
    void addItem(String CartDTOId, String productId);
    void removeItem(String CartDTOId, String productId);

    void clearCart(String cartId);
}
