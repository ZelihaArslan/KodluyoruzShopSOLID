package com.kodluyoruz.homeworkthree.service.payment;

import com.kodluyoruz.homeworkthree.model.enums.PayType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PaymentStrategy {
    private final Map<PayType,Payment> paymentMap;

    public PaymentStrategy(List<Payment> paymentList) {
        this.paymentMap = paymentList.stream()
                .collect(Collectors.toMap(Payment::getType, payment -> payment));

    }
    public Payment getType(PayType type){

        return paymentMap.get(type);
    }
}
