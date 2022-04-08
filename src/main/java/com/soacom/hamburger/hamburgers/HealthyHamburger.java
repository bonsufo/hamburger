package com.soacom.hamburger.hamburgers;

import com.soacom.hamburger.utils.PriceCalculatorUtils;
import com.soacom.hamburger.utils.ReceiptUtils;

import java.math.BigDecimal;
import java.util.List;

import static com.soacom.hamburger.commons.Constants.MAX_TOPPINGS_HEALTHY;

/**
 * Created by SoaCom B.V.
 * Author: Fred Bonsu
 * Date: 07/04/2022
 * Time: 17:14
 */
public class HealthyHamburger extends Hamburger{
    public void addToppings(List<String> toppings) {
        if (toppings.size() > MAX_TOPPINGS_HEALTHY) {
            throw new IndexOutOfBoundsException("You have exceeded the maximum toppings allowed");
        } else {
            setToppingsAndAdditions(toppings);
        }
    }

    public void addTopping(String topping) {
        if (!withinToppingsAllowed(MAX_TOPPINGS_HEALTHY)) {
            throw new IndexOutOfBoundsException("You have exceeded the maximum toppings allowed");
        } else {
            List<String> toppings = getToppingsAndAdditions();
            toppings.add(topping);
            setToppingsAndAdditions(toppings);
        }
    }


    public BigDecimal calculateTotalPrice() {
        BigDecimal total = PriceCalculatorUtils.calculateTotalPrice(getToppingsAndAdditions());
        setTotalPrice(total);
        return total;
    }

    public void printReceipt() {
        ReceiptUtils.printReceipt(this);
    }
}
