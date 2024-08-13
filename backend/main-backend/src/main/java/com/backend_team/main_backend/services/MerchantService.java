package com.backend_team.main_backend.services;

public class MerchantService {

    public int calculateShippingFee(int weight) {
        if (weight <= 0) {
            throw new IllegalStateException("Please provide correct weight");
        }
        if (weight <= 2) {
            return 5;
        } else if (weight <= 5) {
            return 10;
        }
        return 15;
    }

    public boolean validateMerchant(int merchantId) {
        return merchantId == 324;
    }
}
