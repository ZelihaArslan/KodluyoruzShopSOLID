package com.kodluyoruz.homeworkthree.service.payment;

import com.kodluyoruz.homeworkthree.model.checkout.Bill;
import com.kodluyoruz.homeworkthree.model.enums.PayType;
import org.springframework.stereotype.Service;

@Service
public class Cash implements Payment{

    @Override
    public PayType getType() {
        return PayType.CASH;
    }

    @Override
    public void pay(Bill bill) {
        System.out.println("Payment completed with cash, Totalprice: "+bill.getTotalPrice());
    }
}
