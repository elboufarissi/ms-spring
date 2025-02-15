package org.sami.billingservice.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
