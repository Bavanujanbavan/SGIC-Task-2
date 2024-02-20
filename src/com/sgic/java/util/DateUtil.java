// File: DateUtil.java
package com.sgic.java.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date convertStringToDate(String dateString) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.parse(dateString);
    }
}
