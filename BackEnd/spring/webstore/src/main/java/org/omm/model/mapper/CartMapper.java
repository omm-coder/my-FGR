package org.omm.model.mapper;

import org.omm.model.Cart;
import org.omm.model.Cart_Item;
import org.omm.service.ProductService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartMapper implements RowMapper<Cart> {

    private final CartItem_Mapper cartItemMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CartMapper(NamedParameterJdbcTemplate jdbcTemplate,
                      ProductService productService) {
        this.jdbcTemplate = jdbcTemplate;
       cartItemMapper = new CartItem_Mapper(productService);
    }

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("ID");
        Cart cart = new Cart(id);
        String SQL = String.format("SELECT * FROM cart_item WHERE CART_ID = '%s'", id);
        List<Cart_Item> cartItems = jdbcTemplate.query(SQL, cartItemMapper);

        cart.setCartItems(cartItems);
        cart.updateGrandTotal();
        return cart;
    }
}
