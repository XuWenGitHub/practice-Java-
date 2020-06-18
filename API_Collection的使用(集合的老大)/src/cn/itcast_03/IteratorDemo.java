package cn.itcast_03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();

        //创建并添加对象
        c.add("hello");
        c.add("world");
        c.add("java");

        //集合的专用遍历方式，迭代
        Iterator it = c.iterator();//实际返回的肯定是子类对象，这里是多态

        while (it.hasNext()){
            String s = (String) it.next();//向上转型
            System.out.println(s);
        }
    }
}
