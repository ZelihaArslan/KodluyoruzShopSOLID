package com.kodluyoruz.homeworkthree.model.checkout;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Bill {
    private List<BillItem> billItems;
    private double totalPrice;
}
