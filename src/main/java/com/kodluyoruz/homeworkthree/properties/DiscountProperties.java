package com.kodluyoruz.homeworkthree.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix ="discount")
@Data
public class DiscountProperties {
    private double deliveryfee;
    private int deliveryfeelimit;
    private double discountpercentage;
    private double creditcartcommission;

}
