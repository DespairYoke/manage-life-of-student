package com.alidata.Util;

import java.util.Calendar;

/**
 * @author zwd
 * @date 2018/2/28 15:00
 */
public class ParseWeek {

    public static String ParseDayofWeek() {
        Calendar calendar = Calendar.getInstance();
        int data = calendar.get(Calendar.DAY_OF_WEEK);
        switch (data) {

            case 1:return "sonday";
            case 2:return "monday";
            case 3:return "tuesday";
            case 4:return "wednesday";
            case 5:return "toursday";
            case 6:return "friday";
            case 7:return "saturday";
        }
        return null;
    }
}
