package com.pichincha.automationtest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ModelProductPurchase {
    private String name;
    private String country;
    private String city;
    private String carNumber;
    private String expirationMonth;
    private String expirationYear;

    public ModelProductPurchase(List<List<String>> data) {
        this.name = data.get(1).get(0);
        this.country = data.get(1).get(1);
        this.city = data.get(1).get(2);
        this.carNumber = data.get(1).get(3);
        this.expirationMonth = data.get(1).get(4);
        this.expirationYear = data.get(1).get(5);
    }
}