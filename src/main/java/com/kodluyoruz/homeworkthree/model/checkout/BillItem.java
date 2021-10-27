package com.kodluyoruz.homeworkthree.model.checkout;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillItem {
    private String productName;
    private int quantity;
    private String description;
    private double price;
    private double discountedPrice;


}
