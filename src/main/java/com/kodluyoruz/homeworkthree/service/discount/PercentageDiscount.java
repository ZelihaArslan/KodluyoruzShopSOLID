package com.kodluyoruz.homeworkthree.service.discount;


import com.kodluyoruz.homeworkthree.model.cart.Cart;
import com.kodluyoruz.homeworkthree.model.cart.CartItem;
import com.kodluyoruz.homeworkthree.properties.DiscountProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Data
@Component
public class PercentageDiscount implements DiscountService {

    private final DiscountProperties discountProperties;
    @Override
    public double executeDiscount(CartItem cartItem) {
        double price =cartItem.getProduct().getUnitPrice()* discountProperties.getDiscountpercentage()/100;
        price=cartItem.getProduct().getUnitPrice()-price;
        cartItem.getProduct().setUnitPrice(price);

        return price;
    }

    @Override
    public boolean isAcceptable(Cart cart) {
        return cart.getTotalPrice()>=1000;
    }


}
