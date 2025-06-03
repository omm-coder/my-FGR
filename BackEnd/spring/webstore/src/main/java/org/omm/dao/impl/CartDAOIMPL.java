package org.omm.dao.impl;

import org.omm.dao.CartDAO;
import org.omm.dto.CartDTO;
import org.omm.dto.CartItemDTO;
import org.omm.model.Cart;
import org.omm.model.Cart_Item;
import org.omm.model.Product;
import org.omm.model.mapper.CartMapper;
import org.omm.service.ProductService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CartDAOIMPL implements CartDAO {


    private final NamedParameterJdbcTemplate np_jdbc_template;

    private final ProductService productService;

    public CartDAOIMPL(NamedParameterJdbcTemplate npJdbcTemplate,
                       ProductService productService) {
        np_jdbc_template = npJdbcTemplate;
        this.productService = productService;
    }

    @Override
    public void create(CartDTO cartDTO) {
        String INSERT_Cart_SQL = "INSERT INTO Cart(ID) VALUES (:id)";
        Map<String, Object> CartParams = new HashMap<>();
        CartParams.put("id", cartDTO.getId());
        np_jdbc_template.update(INSERT_Cart_SQL, CartParams);


        cartDTO.getCartItems()
                .forEach(cartItemDTO ->{
                    Product productById = productService.
                            getProductById(cartItemDTO.getProductId());
                    String INSERT_Cart_ITEM_SQL =
                            "INSERT INTO Cart_ITEM(ID,PRODUCT_ID,Cart_ID,QUANTITY) "
                            + "VALUES (:id,:product_id, :cart_id, :quantity)";

                    Map<String, Object> CartItemsParams = new HashMap<>();
                    CartItemsParams.put("id", cartItemDTO.getId());
                    CartItemsParams.put("product_id", productById.getProductId());
                    CartItemsParams.put("cart_id", cartDTO.getId());
                    CartItemsParams.put("quantity", cartItemDTO.getQuantity());

                    np_jdbc_template.update(INSERT_Cart_ITEM_SQL, CartItemsParams);
                });
    }

    @Override
    public Cart read(String id) {
        String SQL = "SELECT * FROM Cart WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        CartMapper cartMapper = new CartMapper(np_jdbc_template, productService);
        try {
            return np_jdbc_template.queryForObject(SQL, params, cartMapper);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int update(String id, CartDTO cartDTO) {
        List<CartItemDTO> cartItemsDTO = cartDTO.getCartItems();
        int n_rows = 0;
        for(CartItemDTO cartItemDTO : cartItemsDTO) {
            String SQL = "UPDATE Cart_ITEM SET QUANTITY = :quantity,PRODUCT_ID = :productId " +
                    "WHERE ID = :id AND Cart_ID = :cart_Id";
            Map<String, Object> params = new HashMap<>();
            params.put("quantity", cartItemDTO.getQuantity());
            params.put("productId", cartItemDTO.getProductId());
            params.put("id", cartItemDTO.getId());
            params.put("cart_Id", id);
            n_rows = np_jdbc_template.update(SQL,params);
        }
        return n_rows;
    }

    @Override
    public void delete(String id) {
        String SQL_DELETE_Cart_ITEM = "DELETE FROM Cart_ITEM WHERE Cart_ID = :id";
        String SQL_DELETE_Cart = "DELETE FROM Cart WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        np_jdbc_template.update(SQL_DELETE_Cart_ITEM, params);
        np_jdbc_template.update(SQL_DELETE_Cart, params);

    }

    @Override
    public void addItem(String cartId, String productId) {
        String SQL;
        Cart cart = read(cartId);
        if(cart == null) {
            CartItemDTO newCartItemDTO = new CartItemDTO();
            newCartItemDTO.setId(cartId+productId);
            newCartItemDTO.setProductId(productId);
            newCartItemDTO.setQuantity(1);
            CartDTO newCartDTO = new CartDTO(cartId);
            newCartDTO.addCartItem(newCartItemDTO);
            create(newCartDTO);
            return;
        }

        Map<String, Object> cartItemsParams = new HashMap<>();
        if(cart.getItemByProductId(productId).isEmpty()) {
            SQL = "INSERT INTO Cart_ITEM (ID, PRODUCT_ID, Cart_ID, QUANTITY) " +
                    "VALUES (:id,:productId, :cartId, :quantity)";
            cartItemsParams.put("id", cartId+productId);
            cartItemsParams.put("quantity", 1);
        }else {
            SQL = "UPDATE Cart_ITEM SET QUANTITY = :quantity " +
                    "WHERE Cart_ID = :cartId AND PRODUCT_ID = :productId";
            Optional<Cart_Item> existingItem = cart.getItemByProductId(productId);
            cartItemsParams.put("id", existingItem.get().getId());
            cartItemsParams.put("quantity", existingItem.get().getQuantity()+1);
        }
        cartItemsParams.put("productId", productId);
        cartItemsParams.put("cartId", cartId);
        np_jdbc_template.update(SQL, cartItemsParams);

    }

    @Override
    public void removeItem(String cartId, String productId) {
        String SQL_DELETE_Cart_ITEM = "DELETE FROM Cart_ITEM " +
                "WHERE PRODUCT_ID = :productId AND Cart_ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", cartId);
        params.put("productId", productId);
        np_jdbc_template.update(SQL_DELETE_Cart_ITEM, params);
    }

    @Override
    public void clearCart(String cartId) {
        String SQL_DELETE_CART_ITEM = "DELETE FROM CART_ITEM WHERE CART_ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", cartId);
        np_jdbc_template.update(SQL_DELETE_CART_ITEM, params);

    }


}
