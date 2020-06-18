package cn.itcast_01;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo2 {
    public static void main(String[] args) {
        //测试带All的方法

        //创建集合1
        Collection c1 = new ArrayList();
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");
        //创建集合2
        Collection c2 = new ArrayList();
        c2.add("abc4");
        c2.add("abc5");
        c2.add("abc6");
        c2.add("abc7");

        //添加一个集合的元素
        c1.add(c2);

        //移除一个集合的元素(只要有一个元素被移除了，就返回ture)
        c1.remove(c2);

        //判断集合中是否包含指定的元素集合
        System.out.println("containsAll:"+c1.contains(c2));

        //两个集合都有的元素
        System.out.println("retainAll:"+c1.retainAll(c2));

        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);
    }
}
