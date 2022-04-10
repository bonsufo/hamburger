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
class BasicHamburgerTest {

    @Test
    void maxToppingsBasicBurger() {
        BasicHamburger basicHamburger = new BasicHamburger("Basic Burger", MeatType.BlackAngus, BreadType.Brioche);
        List<String> toppings = new ArrayList<>();
        toppings.add("cheese");
        toppings.add("sauces");
        toppings.add("lettuce");
        toppings.add("tomato");
        basicHamburger.addToppings(toppings);
        BigDecimal total = basicHamburger.calculateTotalPrice();
        assertEquals(toppings.size(), basicHamburger.getToppingsAndAdditions().size());
        assertEquals(total, basicHamburger.getTotalPrice());
    }

    @Test
    void less_toppings_than_max() {
        BasicHamburger basicHamburger = new BasicHamburger("Basic Burger", MeatType.KobeBeef, BreadType.Ciabatt);
        List<String> toppings = new ArrayList<>();
        toppings.add("cheese");
        toppings.add("sauces");
        toppings.add("tomato");
        basicHamburger.addToppings(toppings);
        BigDecimal totalPrice = basicHamburger.calculateTotalPrice();
        basicHamburger.printReceipt();
        assertEquals(toppings.size(), basicHamburger.getToppingsAndAdditions().size());
        assertEquals(totalPrice, basicHamburger.getTotalPrice());
    }

    @Test
    void one_at_a_time_toppings() {
        BasicHamburger basicHamburger = new BasicHamburger("Basic Burger", MeatType.KobeBeef, BreadType.Ciabatt);
        basicHamburger.addTopping("cheese");
        basicHamburger.addTopping("sauces");
        basicHamburger.addTopping("union");
        BigDecimal totalPrice = basicHamburger.calculateTotalPrice();
        basicHamburger.printReceipt();
        assertTrue(basicHamburger.getToppingsAndAdditions().contains("cheese"));
        assertEquals(3, basicHamburger.getToppingsAndAdditions().size());
        assertEquals(totalPrice, basicHamburger.getTotalPrice());
    }

    @Test
    void when_exceededMaxTopping_then_IndexOutOfBoundsException_thrown() {
        BasicHamburger basicHamburger = new BasicHamburger("Basic Burger", MeatType.BlackAngus, BreadType.Brioche);
        basicHamburger.setBread(BreadType.Brioche);
        basicHamburger.setMeat(MeatType.BlackAngus);

        List<String> toppings = new ArrayList<>();
        toppings.add("cheese");
        toppings.add("sauces");
        toppings.add("lettuce");
        toppings.add("tomato");
        toppings.add("union");

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> basicHamburger.addToppings(toppings));

        String expectedMessage = "You have exceeded the maximum toppings allowed";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}