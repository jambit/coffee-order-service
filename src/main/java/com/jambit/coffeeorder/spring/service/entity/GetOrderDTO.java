package com.jambit.coffeeorder.spring.service.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetOrderDTO {

    private String businessId;
    private int quantity;
    private double totalPrice;
}
