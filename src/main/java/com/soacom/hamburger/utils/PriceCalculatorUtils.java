package com.soacom.hamburger.utils;

import com.soacom.hamburger.commons.Constants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Created by SoaCom B.V.
 * Author: Fred Bonsu
 */
public class PriceCalculatorUtils {

    public static BigDecimal calculateTotalPrice(List<String> toppings) {
        return  Constants.BASE_PRICE.add(Constants.DEFAULT_PRICE_TOPPING_ADDITION.multiply(BigDecimal.valueOf(toppings.size())).setScale(2, RoundingMode.CEILING));
    }

    public static BigDecimal calculateTotalPriceCombo() {

        return  Constants.DEFAULT_PRICE_DRINK.add(Constants.DEFAULT_PRICE_CHIPS).add(Constants.BASE_PRICE).setScale(2, RoundingMode.HALF_UP);
    }
}
