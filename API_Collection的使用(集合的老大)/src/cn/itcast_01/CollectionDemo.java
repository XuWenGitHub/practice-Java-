package cn.itcast_01;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        //测试不带All的方法

        //创建对象
        Collection c = new ArrayList();

        //添加一个对象
        //System.out.println("add:"+c.add("hello"));
        c.add("hello");
        c.add("world");
        c.add("java");

        //移除所有元素
        //c.clear();

        //移除一个元素
        //System.out.println("remove:"+c.remove("hello"));
        //System.out.println("remove:"+c.remove("javaee"));

        //判断集合中是否包含指定元素
        System.out.println("contains:"+c.contains("hello"));

        //判断集合是否为空
        System.out.println("isEmpty:"+c.isEmpty());

        //元素个数
        System.out.println("size:"+c.size());

        System.out.println("c:"+c);
    }
}
