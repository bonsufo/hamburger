package com.soacom.hamburger.hamburgers;

import com.soacom.hamburger.commons.BreadType;
import com.soacom.hamburger.commons.MeatType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SoaCom B.V.
 * Author: Fred Bonsu
 */
@Data
public class Hamburger {
    private String burgerName;
    private MeatType meat;
    private BreadType bread;
    private List<String> toppingsAndAdditions = new ArrayList<>();
    private BigDecimal totalPrice;

    public Boolean withinToppingsAllowed(int maxToppingsAllowed) {
        return toppingsAndAdditions.size() <= maxToppingsAllowed;
    }

}
