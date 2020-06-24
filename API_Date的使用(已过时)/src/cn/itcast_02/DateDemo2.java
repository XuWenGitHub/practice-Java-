package cn.itcast_02;

import java.util.Date;

public class DateDemo2 {
    public static void main(String[] args) {
        //创建对象
        Date d = new Date();

        //获取时间
        long time = d.getTime();
        System.out.println(time);

        System.out.println("d:"+d);
        //设置时间
        d.setTime(1000);
        System.out.println("d:"+d);
    }
}
