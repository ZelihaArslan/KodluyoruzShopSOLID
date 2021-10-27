package com.kodluyoruz.homeworkthree.service.payment;

import com.kodluyoruz.homeworkthree.model.checkout.Bill;
import com.kodluyoruz.homeworkthree.model.enums.PayType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CreditCart implements Payment{
    @Override
    public PayType getType() {
        return PayType.CREDIT_CARD;
    }

    @Override
    public void pay(Bill bill) {
        double commission =bill.getTotalPrice() *0.01;
        double price =bill.getTotalPrice() +commission;
        System.out.printf("Payment completed with CreditCard"
                        +"Commision charge: %s "
                        + "Commision Rate: %s"
                        + "Payment After commision: %s",commission,0.01,price);
    }
}
