package com.cart.service;

import com.cart.data.CartData;
import com.cart.entity.Cart;
import com.cart.repository.CartRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Long createCart(CartData data) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(data,cart);
        return cartRepository.save(cart).getId();
    }

    public List<CartData> getCart() {
        List<Cart> cartList = cartRepository.findAll();
        List<CartData> cartData = new ArrayList<CartData>();
        for (Cart c: cartList){
            CartData cd = new CartData();
             //BeanUtils.copyProperties(FROM,TO);
            BeanUtils.copyProperties(c,cd);
            cartData.add(cd);
        }
        //can return string " Item added...."
        return cartData;
    }
    public CartData getCartById(Long cartId) {
        Cart cart =cartRepository.getReferenceById(cartId);
        CartData cartData= new CartData();
        BeanUtils.copyProperties(cart,cartData);
        return cartData;

    }

    public void deleteCart(CartData data) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(data,cart);
        cartRepository.delete(cart);
    }


    public void deleteById(Long cartId) {
        CartData data = getCartById(cartId);
        Cart cart = new Cart();
        BeanUtils.copyProperties(data,cart);
        cartRepository.delete(cart);
    }
}
