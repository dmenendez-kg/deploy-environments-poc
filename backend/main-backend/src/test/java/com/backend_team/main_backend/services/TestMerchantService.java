package com.backend_team.main_backend.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMerchantService {

    @Test
    public void incorrectWeight() {
        MerchantService merchantService = new MerchantService();
        assertThrows(IllegalStateException.class, () -> merchantService.calculateShippingFee(-1));
    }

    @Test
    public void firstRangeWeight() {
        MerchantService merchantService = new MerchantService();
        assertEquals(5, merchantService.calculateShippingFee(1));
    }
}
