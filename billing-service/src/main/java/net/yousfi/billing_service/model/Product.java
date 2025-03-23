package net.yousfi.billing_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private String Id;
    private String name;
    private double price;
    private int quantity;
}
