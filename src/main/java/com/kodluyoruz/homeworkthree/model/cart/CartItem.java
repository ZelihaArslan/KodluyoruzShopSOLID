package com.kodluyoruz.homeworkthree.model.cart;

import com.kodluyoruz.homeworkthree.model.Product;
import com.kodluyoruz.homeworkthree.service.discount.DiscountService;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {
    private Product product;
    private int quantity;
    private DiscountService discountService;

    public double getUnitPrice(){
        return product.getUnitPrice() * quantity;
    }



}
