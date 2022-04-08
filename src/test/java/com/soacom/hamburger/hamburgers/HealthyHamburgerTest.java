package com.soacom.hamburger.hamburgers;

import com.soacom.hamburger.commons.BreadType;
import com.soacom.hamburger.commons.MeatType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by SoaCom B.V.
 * Author: Fred Bonsu
 */
class HealthyHamburgerTest {

    @Test
    void addToppings() {
        HealthyHamburger healthyHamburger = new HealthyHamburger();
        healthyHamburger.setBurgerName("Healthy Hamburger");
        healthyHamburger.setBread(BreadType.Ciabatt);
        healthyHamburger.setMeat(MeatType.KobeBeef);

//        cheese, sauces, lettuce, tomato, union
        List<String> toppings = new ArrayList<>();
//        cheese, sauces, lettuce, tomato, union
        toppings.add("cheese");
        toppings.add("sauces");
        toppings.add("lettuce");
        toppings.add("tomato");
        healthyHamburger.addToppings(toppings);
        BigDecimal total = healthyHamburger.calculateTotalPrice();
        assertEquals(toppings.size(), healthyHamburger.getToppingsAndAdditions().size());
        assertEquals(total, healthyHamburger.getTotalPrice());
        healthyHamburger.printReceipt();
    }

    @Test
    void addTopping() {
        HealthyHamburger healthyHamburger = new HealthyHamburger();
        healthyHamburger.setBurgerName("Healthy Hamburger");
        healthyHamburger.setBread(BreadType.Ciabatt);
        healthyHamburger.setMeat(MeatType.KobeBeef);

//        cheese, sauces, lettuce, tomato, union
        healthyHamburger.addTopping("cheese");
        healthyHamburger.addTopping("sauces");
        healthyHamburger.addTopping("union");
        BigDecimal totalPrice = healthyHamburger.calculateTotalPrice();
        healthyHamburger.printReceipt();
        assertTrue(healthyHamburger.getToppingsAndAdditions().contains("cheese"));
        assertEquals(3, healthyHamburger.getToppingsAndAdditions().size());
        assertEquals(totalPrice, healthyHamburger.getTotalPrice());
    }

    @Test
    void when_exceededMaxTopping_then_IndexOutOfBoundsException_thrown() {
        HealthyHamburger healthyHamburger = new HealthyHamburger();
        healthyHamburger.setBread(BreadType.Brioche);
        healthyHamburger.setMeat(MeatType.BlackAngus);

        List<String> toppings = new ArrayList<>();
        toppings.add("cheese");
        toppings.add("sauces");
        toppings.add("lettuce");
        toppings.add("tomato");
        toppings.add("union");
        toppings.add("egg");
        toppings.add("cucumber");

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> healthyHamburger.addToppings(toppings));

        String expectedMessage = "You have exceeded the maximum toppings allowed";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}