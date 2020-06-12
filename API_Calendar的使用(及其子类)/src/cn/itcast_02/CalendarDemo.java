package cn.itcast_02;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        //获取当前的日历对象
        Calendar c = Calendar.getInstance();

        //获取年
        int year = c.get(Calendar.YEAR);
        //获取月
        int month = c.get(Calendar.MONTH);
        //获取日
        int date = c.get(Calendar.DATE);
        System.out.println(year+"年"+(month+1)+"月"+ date+"日");

        //三年前的今天
        c.add(Calendar.YEAR,-3);
        //获取年
         year = c.get(Calendar.YEAR);
        //获取月
         month = c.get(Calendar.MONTH);
        //获取日
         date = c.get(Calendar.DATE);
        System.out.println(year+"年"+(month+1)+"月"+ date+"日");

        //五年后的十天前
        c.add(Calendar.YEAR,5);
        c.add(Calendar.DATE,-10);
        //获取年
         year = c.get(Calendar.YEAR);
        //获取月
         month = c.get(Calendar.MONTH);
        //获取日
         date = c.get(Calendar.DATE);
        System.out.println(year+"年"+(month+1)+"月"+ date+"日");
        System.out.println("-----------------");

        c.set(2000,11,11);
        //获取年
        year = c.get(Calendar.YEAR);
        //获取月
        month = c.get(Calendar.MONTH);
        //获取日
        date = c.get(Calendar.DATE);
        System.out.println(year+"年"+(month+1)+"月"+ date+"日");
    }
}
