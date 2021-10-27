package com.kodluyoruz.homeworkthree.page;

import com.kodluyoruz.homeworkthree.model.checkout.Bill;
import com.kodluyoruz.homeworkthree.model.enums.PayType;
import com.kodluyoruz.homeworkthree.service.payment.Payment;
import com.kodluyoruz.homeworkthree.service.payment.PaymentStrategy;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

@Data
@Component
public class PagePayment {
    private  final Scanner scanner;
    private final PaymentStrategy paymentStrategy;
    public void run(Bill bill) {
        System.out.print("SELECT PAYMENT METHOD "+ Arrays.toString(PayType.values())+" : ");
        PayType payType=PayType.valueOf(scanner.nextLine());
        Payment payment =paymentStrategy.getType(payType);
        payment.pay(bill);
    }
}
