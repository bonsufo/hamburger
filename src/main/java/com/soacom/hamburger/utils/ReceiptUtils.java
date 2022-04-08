package com.soacom.hamburger.utils;

import com.soacom.hamburger.commons.Constants;
import com.soacom.hamburger.hamburgers.Hamburger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.soacom.hamburger.commons.Constants.*;

/**
 * Created by SoaCom B.V.
 * Author: Fred Bonsu
 */
public class ReceiptUtils {

    public static void printReceipt(Hamburger hamburger) {
        printHeader(hamburger);
        if (hamburger.getToppingsAndAdditions().size() > 0) {
            List<String> toppings = hamburger.getToppingsAndAdditions();
            System.out.println("Total Toppings : " + toppings.size());
            System.out.println("Topping                        Price");
            BigDecimal toppingPrice = DEFAULT_PRICE_TOPPING_ADDITION.setScale(2, RoundingMode.HALF_UP);
            for (String topping : toppings) {
                System.out.println(topping + ":                 " + toppingPrice);
            }
            System.out.println("Subtotal:                      " + toppingPrice.multiply(BigDecimal.valueOf(toppings.size())));
            System.out.println("Total:                         " + hamburger.getTotalPrice());
        }
    }

    public static void printReceiptCombo(Hamburger hamburger) {
        printHeader(hamburger);
        List<String> toppings = hamburger.getToppingsAndAdditions();

        System.out.println("Total Additions : " + toppings.size());
        System.out.println("Additions                          Price");
        System.out.println("Drinks:                            " + DEFAULT_PRICE_DRINK.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Chips:                             " + DEFAULT_PRICE_CHIPS.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Subtotal:                          " + DEFAULT_PRICE_DRINK.add(DEFAULT_PRICE_CHIPS).setScale(2, RoundingMode.HALF_UP));
        System.out.println("Total:                             " + hamburger.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
    }

    private static void printHeader(Hamburger hamburger) {
        System.out.println("===========Your Order: " + hamburger.getBurgerName() + "===========");
        System.out.println("Bread type : " + hamburger.getBread().getValue());
        System.out.println("Meat type  : " + hamburger.getMeat().getValue());

        System.out.println("Base price : " + Constants.BASE_PRICE.setScale(2, RoundingMode.HALF_UP));

    }
}
