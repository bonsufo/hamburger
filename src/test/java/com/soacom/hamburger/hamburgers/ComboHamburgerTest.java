package com.soacom.hamburger.hamburgers;

import com.soacom.hamburger.commons.BreadType;
import com.soacom.hamburger.commons.MeatType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by SoaCom B.V.
 * Author: Fred Bonsu
 */
class ComboHamburgerTest {

    @Test
    void addToppingAndAdditions() {
        ComboHamburger comboHamburger = new ComboHamburger("Combo Hamburger",
                MeatType.KobeBeef, BreadType.Ciabatt, "French fries", "Fanta");

        BigDecimal totalPrice = comboHamburger.calculateTotalPrice();
        comboHamburger.printReceipt();
        assertTrue(comboHamburger.getToppingsAndAdditions().contains("Fanta"));
        assertEquals(2, comboHamburger.getToppingsAndAdditions().size());
        assertEquals(totalPrice, comboHamburger.getTotalPrice());
    }
}