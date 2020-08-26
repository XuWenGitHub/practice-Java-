package cn.itcast_02;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        //创建集合对象
        List list = new ArrayList();

        //添加元素
        list.add("hello");
        list.add("world");
        list.add("java");

        //在指定位置添加元素
        //list.add(1,"android");

        //获取指定位置的元素
        //System.out.println("get:"+list.get(1));

        //根基索引删除元素，返回被删除的元素
        //System.out.println("remove:"+list.remove(1));

        //修改功能
        System.out.println("set:"+list.set(2,"javaee"));
        System.out.println("list:"+list);
    }
}
