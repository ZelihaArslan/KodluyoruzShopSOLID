package com.kodluyoruz.homeworkthree.service;


import com.kodluyoruz.homeworkthree.model.cart.Cart;
import com.kodluyoruz.homeworkthree.model.cart.CartItem;
import com.kodluyoruz.homeworkthree.model.checkout.Bill;
import com.kodluyoruz.homeworkthree.model.checkout.BillItem;
import com.kodluyoruz.homeworkthree.service.discount.DiscountStrategy;
import com.kodluyoruz.homeworkthree.service.discount.PercentageDiscount;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data

public class CheckoutService {
    private int deliveryfee;
    private int deliveryfeelimit;
    private final DiscountStrategy discountStrategy;

    public Bill checkout(Cart cart) {
        List<BillItem> billItems = cart.getItems()
                .stream()
                .map(cartItem -> BillItem.builder()
                        .productName(cartItem.getProduct().getName())
                        .quantity(cartItem.getQuantity())
                        .price(cartItem.getUnitPrice())
                        .description(cartItem.getProduct().getDescription())
                        .discountedPrice(discountStrategy.executeDiscount(cart))
                        .build())
                .collect(Collectors.toList());

        double totalSum = billItems.stream()
                .map(BillItem::getDiscountedPrice)
                .mapToDouble(d -> d)
                .sum();


        if(totalSum==0){
            totalSum= cart.getTotalPrice();
        }
        if(totalSum<deliveryfeelimit){
            totalSum=totalSum+deliveryfee;
        }

        return Bill.builder()
                .billItems(billItems)
                .totalPrice(totalSum)
                .build();


    }
}
