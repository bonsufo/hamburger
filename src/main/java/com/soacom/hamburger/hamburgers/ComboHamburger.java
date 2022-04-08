package com.soacom.hamburger.hamburgers;

import com.soacom.hamburger.utils.PriceCalculatorUtils;
import com.soacom.hamburger.utils.ReceiptUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SoaCom B.V.
 * Author: Fred Bonsu
 */
public class ComboHamburger extends Hamburger {
    private String chips;
    private String drinks;

    public ComboHamburger(String chips, String drinks) {
        this.chips = chips;
        this.drinks = drinks;
        addToppingAndAdditions();
    }

    private void addToppingAndAdditions() {
        List<String> additions= new ArrayList<>();
        additions.add(chips);
        additions.add(drinks);

        setToppingsAndAdditions(additions);
    }

    public BigDecimal calculateTotalPrice() {
        BigDecimal total = PriceCalculatorUtils.calculateTotalPrice(getToppingsAndAdditions());
        setTotalPrice(total);

        return total;
    }

    public void printReceipt() {
        ReceiptUtils.printReceiptCombo(this);
    }
}
