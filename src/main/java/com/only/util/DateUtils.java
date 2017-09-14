/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: DateUtils.java
 * Author:   14040897
 * Date:     2015-4-23 上午11:24:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.only.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @author 14040897
 */
public class DateUtils {
    

    private DateUtils() {
    }






    /**
     * 日期格式化
     * 
     * @param dateTime
     * @param pattern
     */
    public static String formatDate(Date dateTime, String pattern) {
        if (dateTime == null || StringUtils.isEmpty(pattern)) {
            return null;
        } else {
            DateFormat df = new SimpleDateFormat(pattern);
            return df.format(dateTime);
        }
   
    }

    public static String formatDate(Date dateTime) {
        return formatDate(dateTime,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 日期格式化
     * 
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date parseDate(String dateStr, String pattern) {
        if (dateStr == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 日期格式化
     * 
     * @param dateStr
     */
    public static String formatDate(String dateStr, String fromPattern, String toPattern) {
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(fromPattern) || StringUtils.isEmpty(toPattern)) {
            return "";
        }
        return formatDate(parseDate(dateStr, fromPattern), toPattern);
    }

    /**
     * 日期加减天数
     * 
     * @param date
     * @param num
     * @return Date
     */
    public static Date addDays(Date date, int num) {
        Date result = null;
        if (date != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, num);
            result = c.getTime();
        }
        return result;
    }

    /**
     * 日期加减天数
     * 
     * @param dateStr
     * @param pattern
     * @param num
     * @return
     */
    public static String addDays(String dateStr, String pattern, int num) {
        String result = "";
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(pattern)) {
            return result;
        }
        Date oldDate = parseDate(dateStr, pattern);
        Date newDate = addDays(oldDate, num);
        result = formatDate(newDate, pattern);
        return result;
    }



    /**
     * 根据出生日期获取年龄
     * @param birthDay
     * @return
     */
    public  static int getAge(Date birthDay){
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            return 0;
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH)+1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                //monthNow==monthBirth 
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                //monthNow>monthBirth 
                age--;
            }
        }
        return age;
    }
    
    


    /**
     * 获取两个时间相差的小时
     * @param start
     * @param end
     * @return
     */
    public static long dateDiffHour(Date start,Date end)
    {
        long nd = 1000L * 24 * 60 * 60;// 一天的毫秒数   
        long nh = 1000L * 60 * 60;// 一小时的毫秒数   
        //long nm = 1000 * 60;// 一分钟的毫秒数   
        //long ns = 1000;// 一秒钟的毫秒数
        long day = 0;
        long hour = 0;
       // long min = 0;
        //long sec = 0;
        // 获得两个时间的毫秒时间差异   
        long diff = end.getTime() - start.getTime();
        day = diff / nd;// 计算差多少天   
        hour = diff % nd / nh + day * 24;// 计算差多少小时   
        //min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟   
        //sec = diff % nd % nh % nm / ns;// 计算差多少秒
        return hour;
    }


}