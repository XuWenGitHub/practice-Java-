package cn.itcast_01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) throws ParseException {
        //Date -- String
        //创建日期对象
        Date d = new Date();
        //创建格式化对象
        //SimpleDateFormat sdf = new SimpleDateFormat();
        //给定模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);


        //String -- Date
        String s2 = "2020-03-19 16:13:13";
        //在吧一个字符串解析为日期的时候，请注意格式必须和给定的字符串格式匹配
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = sdf2.parse(s2);
        System.out.println(d2);
    }
}
