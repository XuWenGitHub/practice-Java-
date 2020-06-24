package cn.itcast_01;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        //创建对象
        Date d = new Date();
        System.out.println("d:"+d);

        //创建对象
        long time = 1000*60*60; //一小时
        Date d2 = new Date(time);
        System.out.println("d2:"+d2);
    }
}
