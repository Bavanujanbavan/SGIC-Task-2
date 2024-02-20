// File: EmailValidator.java
package com.sgic.java.util;

public class EmailValidator {
    public static String validateEmail(String email) {
        if (email == null || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            return "Email is Invalid";
        }
        return null;
    }
}
