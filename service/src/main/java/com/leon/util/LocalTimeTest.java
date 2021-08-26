package com.leon.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
  * ClassName:    Test
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/8/6
  * version     1.0.0
 */
public class LocalTimeTest {
    public static void main(String[] args){
        LocalDateTime now = LocalDateTime.of(2021,8,6,0,2,0);

        int dayOfMonth = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();

        int workTimeHour = 5;
        int workTimeMinute = 0;
        int workTimeEndHour = 23;
        int workTimeEndMinute = 0;
        // 正常的开始结束时间
        LocalDateTime accessStart = LocalDateTime.of(now.getYear(), now.getMonth(), dayOfMonth, workTimeHour, workTimeMinute, 0);
        LocalDateTime accessEnd = LocalDateTime.of(now.getYear(), now.getMonth(), dayOfMonth, workTimeEndHour, workTimeEndMinute, 0);
        // 如果存在跨天排班
        if (workTimeEndHour<workTimeHour){
            // 当前时间已经跨天，而且还在工作时间内
            if ( now.compareTo(accessStart)<0&&now.compareTo(accessEnd)<0){
                accessStart = accessStart.minusDays(1);
            }else {
                accessEnd = accessEnd.plusDays(1);
            }
        }

//        Long startTime = LocalDateTime.of(now.getYear(), now.getMonth(), dayOfMonth, 5, 0, 0).toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        Long endTime = LocalDateTime.of(now.getYear(), now.getMonth(), dayOfMonth, 1, 0, 0).toInstant(ZoneOffset.of("+8")).toEpochMilli();

        if (now.compareTo(accessStart)>0 && now.compareTo(accessEnd)<0){
            System.out.println(111111);
        }
    }

}