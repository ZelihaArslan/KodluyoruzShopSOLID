package com.kodluyoruz.homeworkthree.service.payment;

import com.kodluyoruz.homeworkthree.model.checkout.Bill;
import com.kodluyoruz.homeworkthree.model.enums.PayType;

public interface Payment {
    PayType getType();
    void pay(Bill bill);
}
