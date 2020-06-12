package cn.itcast_01;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        //其日历字段已由当前日期和时间初始化
        Calendar rightNow = Calendar.getInstance();//子类对象  多态

        //获取年
        int year = rightNow.get(Calendar.YEAR);
        //获取月
        int month = rightNow.get(Calendar.MONTH);
        //获取日
        int date = rightNow.get(Calendar.DATE);

        System.out.println(year+"年"+(month+1)+"月"+ date+"日");
    }
}
