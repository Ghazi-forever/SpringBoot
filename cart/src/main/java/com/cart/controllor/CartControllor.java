package com.cart.controllor;

import com.cart.data.CartData;
import com.cart.entity.Cart;
import com.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartControllor {

    @Autowired
    private CartService cartService;


    @PostMapping
    public Long postCart(@RequestBody CartData cart ){
        return cartService.createCart(cart);
    }

    @GetMapping
    public List<CartData> getAllCart(){
        return cartService.getCart();
    }


    //get by id
    @GetMapping("/{cartId}")
    public CartData getCartByID(@PathVariable Long cartId){
        return cartService.getCartById(cartId);

}

    @PutMapping
    public Long UpdateCart(@RequestBody CartData cart ){
        return cartService.createCart(cart);
    }

    @DeleteMapping
    public void deleteCart(@RequestBody CartData cart){
        cartService.deleteCart(cart);
    }

    //delete by id
    @DeleteMapping("{cartId}")
    public void deleteCartByID(@PathVariable Long cartId) {
        cartService.deleteById(cartId);
    }

}
