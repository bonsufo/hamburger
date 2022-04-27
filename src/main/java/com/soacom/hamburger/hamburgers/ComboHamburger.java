package com.soacom.hamburger.hamburgers;

import com.soacom.hamburger.commons.BreadType;
import com.soacom.hamburger.commons.MeatType;
import com.soacom.hamburger.utils.PriceCalculatorUtils;
import com.soacom.hamburger.utils.ReceiptUtils;
import lombok.NonNull;
import org.junit.platform.commons.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SoaCom B.V.
 * Author: Fred Bonsu
 */
public class ComboHamburger extends Hamburger {
    private final String chips;
    private final String drinks;

    public ComboHamburger(@NonNull String burgerName, @NonNull MeatType meat, @NonNull BreadType bread, String chips, String drinks) {
        super(burgerName, meat, bread);
        this.chips = chips;
        this.drinks = drinks;
        if (StringUtils.isBlank(burgerName)) {
            throw new IllegalArgumentException("Burger name cannot be blank");
        }
        if (StringUtils.isBlank(chips)) {
            throw new IllegalArgumentException("Chips cannot be blank. You must add chips");
        }
        if (StringUtils.isBlank(drinks)) {
            throw new IllegalArgumentException("Drink cannot be blank. You must add drink");
        }
        addToppingAndAdditions();
    }

    private void addToppingAndAdditions() {
        List<String> additions= new ArrayList<>();
        additions.add(chips);
        additions.add(drinks);

        setToppingsAndAdditions(additions);
    }

    public BigDecimal calculateTotalPrice() {
        BigDecimal total = PriceCalculatorUtils.calculateTotalPriceCombo();
        setTotalPrice(total);

        return total;
    }

    public void printReceipt() {
        ReceiptUtils.printReceiptCombo(this);
    }
}
