package org.example.entities;

import java.math.BigDecimal;

public class Category {
    public static final String ADULT = "ADULT";
    public static final String STUDENT = "STUDENT";
    public static final String SENIOR = "SENIOR";
    public static final String CHILD = "CHILD";
    public static final String VETERAN = "VETERAN";
    public static final String DISABLED = "DISABLED";

    public static BigDecimal getDiscount (String category){
        return switch (category) {
            case STUDENT -> new BigDecimal("0.20");
            case SENIOR -> new BigDecimal("0.30");
            case VETERAN, DISABLED -> new BigDecimal("0.40");
            case CHILD -> new BigDecimal("0.50");
            default -> BigDecimal.ZERO;
        };
    }
}

