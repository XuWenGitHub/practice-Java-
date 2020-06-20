package cn.itcast_02;

import java.text.ParseException;
import java.util.Date;

/*
* 工具类的测试
* */
public class DateUtilDemo {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        // yyyy-MM-dd HH:mm:ss
        String s = DateUtil.dateToString(d,"yyyy-MM-dd HH:mm:ss");
        System.out.println(s);

        String str = "2020-03-19";
        Date d2 = DateUtil.stringToDate(str,"yyyy-MM-dd");
        System.out.println(d2);
    }
}
