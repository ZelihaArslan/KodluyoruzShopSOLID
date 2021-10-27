package com.kodluyoruz.homeworkthree.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class Product {
    private  String name;
    private  String description;
    private double unitPrice;

}
