package com.yang.learn.multisource1.utils;

import java.util.Arrays;
import java.util.List;

public class DateUtils {
    public static void main(String[] args) {
        System.out.println(add_month("20190125", "7"));
    }

    /***
     * @param currDay 当前天数
     * @param days 增加天数
     */
    public static String add_month(String currDay, String days) {
        if (currDay.length() != 8) {
            throw new RuntimeException("illegal param currDay");
        }
        if (Integer.parseInt(days) <= 0) {
            throw new RuntimeException("illegal param days");
        }
        int year = Integer.parseInt(currDay.substring(0, 4));
        int month = Integer.parseInt(currDay.substring(4, 6));
        int day = Integer.parseInt(currDay.substring(6, 8));
        int plusDays = Integer.parseInt(days);

        //结果计算
        List<Integer> daysMonths = monthCarry(year, month, day + plusDays);
        year = daysMonths.get(0);
        month = daysMonths.get(1);
        day = daysMonths.get(2);
        return String.format("%s%s%s", year, month < 10 ? "0" + month : month, day < 10 ? "0" + day : day);
    }

    /**
     * 月份进位
     */
    private static List<Integer> monthCarry(int year, int month, int plusDays) {
        int monthDays = monthDays(year + month / 12, (month % 12 == 0) ? 12 : month % 12);

        if (plusDays <= monthDays) {
            return Arrays.asList(year + month / 12, (month % 12 == 0) ? 12 : month % 12, plusDays);
        }
        Arrays.asList(month, plusDays);
        plusDays -= monthDays;
        month++;
        return monthCarry(year, month, plusDays);
    }

    /**
     * 判断某月有几天
     *
     * @param year
     * @param month
     */
    private static int monthDays(int year, int month) {
        int days = 0;
        if (month != 2) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;

            }
        } else {
            // 闰年
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                days = 29;
            else
                days = 28;

        }
        return days;
    }
}
