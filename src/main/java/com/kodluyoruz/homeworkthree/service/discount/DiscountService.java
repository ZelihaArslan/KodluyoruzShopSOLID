package com.kodluyoruz.homeworkthree.service.discount;

import com.kodluyoruz.homeworkthree.model.cart.Cart;
import com.kodluyoruz.homeworkthree.model.cart.CartItem;

public interface DiscountService {
    double executeDiscount(CartItem cart);
    boolean isAcceptable(Cart cart);
}
