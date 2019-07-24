package com.test.testApp.test.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class bigNumber {
    public static void main(String[] args) {
        double d01 = 1.00;
        double d02 = 3.00;
        BigDecimal bigDecimal = new BigDecimal(d01);
        BigDecimal ret = bigDecimal.divide(new BigDecimal(d02),2,RoundingMode.DOWN);
        BigDecimal ret02 = bigDecimal.divide(new BigDecimal(d02),2,RoundingMode.UP);
        BigDecimal ret03 = bigDecimal.divide(new BigDecimal(d02),2,RoundingMode.CEILING);
        BigDecimal ret04 = bigDecimal.divide(new BigDecimal(d02),2,RoundingMode.FLOOR);
        double v = ret.doubleValue();
        System.out.println(d01/d02);
    }
}
