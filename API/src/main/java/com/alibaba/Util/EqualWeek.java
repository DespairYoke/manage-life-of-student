package com.alibaba.Util;


import com.alibaba.domain.UserTask;

import java.util.Calendar;

/**
 * @author zwd
 * @date 2018/1/16 14:58
 */
public class EqualWeek {

    public static void equalWeek(UserTask userTask, double count)  {

        Calendar date = Calendar.getInstance();
        // date.get(Calendar.DAY_OF_WEEK)-1;
         switch (date.get(Calendar.DAY_OF_WEEK))
         {
             case 1:userTask.setSonday(count);break;
             case 2:userTask.setMonday(count);break;
             case 3:userTask.setTuesday(count);break;
             case 4:userTask.setWednesday(count);break;
             case 5:userTask.setToursday(count);break;
             case 6:userTask.setFriday(count);break;
             case 7:userTask.setSaturday(count);break;
             default:;
         }
    }
}
