package com.kodluyoruz.homeworkthree.service.discount;

import com.kodluyoruz.homeworkthree.model.cart.Cart;
import com.kodluyoruz.homeworkthree.model.cart.CartItem;
import com.kodluyoruz.homeworkthree.properties.DiscountProperties;
import lombok.Data;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@Order(Ordered.HIGHEST_PRECEDENCE)
public class Buy2Take3Discount  implements DiscountService{

    private final DiscountProperties discountProperties;
    List<Double> doubleList=new ArrayList<>();

    @Override
    public double executeDiscount(CartItem cart) {
        int discQuantity = cart.getQuantity() /3;
        int paidQuantity =cart.getQuantity()%3;
        double unitPrice= cart.getProduct().getUnitPrice();
        cart.getProduct().setUnitPrice((unitPrice*discQuantity*2)+paidQuantity* unitPrice);
        return unitPrice;
    }

    @Override
    public boolean isAcceptable(Cart cart) {
        return cart.getItems().get(0).getQuantity()>5;
    }

}
