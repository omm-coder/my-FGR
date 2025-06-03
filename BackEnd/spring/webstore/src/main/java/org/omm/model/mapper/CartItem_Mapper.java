package org.omm.model.mapper;

import org.omm.model.Cart_Item;
import org.omm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CartItem_Mapper implements RowMapper<Cart_Item> {

    private final ProductService productService;

    public CartItem_Mapper(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart_Item mapRow(ResultSet rs, int rowNum) throws SQLException {

            Cart_Item cartItem = new Cart_Item(rs.getString("ID"));
            cartItem.setProduct(productService
                    .getProductById(rs.getString("PRODUCT_ID")));
            cartItem.setQuantity(rs.getInt("QUANTITY"));
            return cartItem;

        }
}
