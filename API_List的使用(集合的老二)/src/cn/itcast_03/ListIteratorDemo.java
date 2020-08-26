package cn.itcast_03;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        //创建list集合对象
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");

        //要想逆着遍历必须先顺着遍历
        ListIterator lit = list.listIterator();
        while (lit.hasNext()){
            String s = (String)lit.next();
            System.out.println(s);
        }

        System.out.println("-----------");

        while (lit.hasPrevious()){
            String ss = (String)lit.previous();
            System.out.println(ss);
        }
    }
}
