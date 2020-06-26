package cn.itcast_01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("今天天气很好");
        try {
            method();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("但是就是不该有雾霾");
        method2();
    }

    //运行时期的异常的抛出
    public static void method2(){
        int a=10;
        int b=0;
        System.out.println(a/b);
    }

    //编译期异常的抛出
    //在方法声明上抛出，是为了告诉调用者，你注意了，我有问题
    public static void method() throws ParseException {
        String s = "2020-4-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(s);
        System.out.println(d);
    }
}
