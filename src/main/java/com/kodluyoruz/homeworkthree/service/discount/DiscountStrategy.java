package com.kodluyoruz.homeworkthree.service.discount;


import com.kodluyoruz.homeworkthree.model.cart.Cart;
import com.kodluyoruz.homeworkthree.model.cart.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountStrategy{
    private final List<DiscountService> discountlist;
    private double totalprice =0;

    public double executeDiscount(Cart cart){
        for(CartItem cartItem : cart.getItems()){
            discountlist.stream()
                    .filter(discountService -> discountService.isAcceptable(cart))
                    .findFirst()
                    .ifPresent(discountService -> totalprice = discountService.executeDiscount(cartItem));
        }
        return totalprice;
    }

}
