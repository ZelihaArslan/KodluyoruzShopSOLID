package com.kodluyoruz.homeworkthree.model.cart;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private final List<CartItem> cartItems;

    public Cart(List<CartItem> cartItems) {

        this.cartItems = new ArrayList<>();
    }
    public void AddItem(CartItem cartItem){
        cartItems.add(cartItem);
    }
    public List<CartItem> getItems(){
        return cartItems;
    }

    public double getTotalPrice() {
        return cartItems.stream().map(CartItem::getUnitPrice).mapToDouble(value -> value).sum();
    }
}
