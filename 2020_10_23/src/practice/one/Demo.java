package practice.one;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/23 19:31
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        java.util.Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));
        //表示1970年过了10000毫秒后到达的时间
        java.sql.Date d2 = new java.sql.Date(10000);
    }
}
