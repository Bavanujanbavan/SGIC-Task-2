// File: MathUtil.java
package com.sgic.java.util;

public class MathUtil {
    @SuppressWarnings("unchecked")
    public static <T extends Number> T add(T num1, T num2) {
        if (num1 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        } else if (num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported numeric type");
        }
    }
}
