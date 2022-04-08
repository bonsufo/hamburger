package com.soacom.hamburger.commons;

import lombok.Getter;

/**
 * Created by SoaCom B.V.
 * Author: Fred Bonsu
 */
@Getter
public enum BreadType {

    Wholegrain("Wholegrain"),
    White("White"),
    Brioche("Brioche"),
    Ciabatt("Ciabatt");

    private final String value;

    BreadType(String value) {
        this.value = value;
    }
}
