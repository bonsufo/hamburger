package com.soacom.hamburger.commons;

import lombok.Getter;

/**
 * Created by SoaCom B.V.
 * Author: Fred Bonsu
 */
@Getter
public enum MeatType {
    BlackAngus("Black angus patty"),
    KobeBeef("Kobe beef patty"),
    Vegan("Vegan patty"),
    Fish("Fish patty");

    private final String value;


    MeatType(String value) {
        this.value = value;
    }
}
