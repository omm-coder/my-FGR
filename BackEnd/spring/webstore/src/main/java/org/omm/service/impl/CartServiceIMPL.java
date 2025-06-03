package org.omm.service.impl;

import org.omm.dao.impl.CartDAOIMPL;
import org.omm.dto.CartDTO;
import org.omm.exception.InvalidCartException;
import org.omm.model.Cart;
import org.omm.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceIMPL implements CartService {

    private final CartDAOIMPL cartDAOIMPL;

    public CartServiceIMPL(CartDAOIMPL cartDAOIMPL) {
        this.cartDAOIMPL = cartDAOIMPL;
    }

    @Override
    public void create(CartDTO cart) {
        cartDAOIMPL.create(cart);
    }

    @Override
    public Cart read(String id) {
        return cartDAOIMPL.read(id);
    }

    @Override
    public int update(String id, CartDTO cart) {
        return cartDAOIMPL.update(id, cart);
    }

    @Override
    public void delete(String id) {
        cartDAOIMPL.delete(id);
    }

    @Override
    public void addItem(String cartId, String productId) {
        cartDAOIMPL.addItem(cartId, productId);
    }

    @Override
    public void removeItem(String cartId, String productId) {
        cartDAOIMPL.removeItem(cartId,productId);
    }

    @Override
    public Cart validate(String cartId) {
        System.out.println("the cartId that would validate is: "+ cartId);
        Cart cart = cartDAOIMPL.read(cartId);
        if(cart==null || cart.getCartItems().isEmpty()) {
            throw new InvalidCartException(cartId);
        }
        return cart;

    }

    @Override
    public void clearCart(String cartId) {
        cartDAOIMPL.clearCart(cartId);
    }
}
