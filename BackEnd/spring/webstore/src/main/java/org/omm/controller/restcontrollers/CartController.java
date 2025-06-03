package org.omm.controller.restcontrollers;

import jakarta.servlet.http.HttpSession;
import org.omm.dto.CartDTO;
import org.omm.dto.CartItemDTO;
import org.omm.model.Cart;
import org.omm.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/cart")
public class CartController {


    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody CartDTO cart) {
        System.out.println("Inside Post controller");
        System.out.println("Getting CartDTO obj values");
        System.out.println("Listing product ids that in the list of cartItem of cartDto obj");
        System.out.println("current cartDTo id: "+ cart.getId());
        for (CartItemDTO cartItem: cart.getCartItems())
            System.out.println("p-Id: "+cartItem.getProductId());
        cartService.create(cart);
    }

    @GetMapping("/{cartId}")
    public Cart read(@PathVariable(value = "cartId")
                     String cartId) {
        return cartService.read(cartId);
    }

    @PutMapping("/{cartId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@PathVariable(value = "cartId")
                       String cartId, @RequestBody CartDTO cart) {
        cart.setId(cartId);
        int to = cartService.update(cartId, cart);
        System.out.println("Number of rows updated: "+ to);
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(value = "cartId")
                       String cartId) {
        cartService.delete(cartId);
    }

    @PutMapping("/add/{productId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void addItem(@PathVariable String
                                productId, HttpSession session) {
        cartService.addItem(session.getId(),productId);
    }

    @PutMapping("/remove/{productId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeItem(@PathVariable String
                                   productId, HttpSession session) {
        System.out.println("Getting the cart id of session: "+ session.getId());
        cartService.removeItem(session.getId(),productId);
    }


}
