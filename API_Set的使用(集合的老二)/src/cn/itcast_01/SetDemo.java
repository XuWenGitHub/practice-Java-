package cn.itcast_01;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        //创建集合对象
        Set<String> set = new HashSet<String>();

        //创建并添加元素
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("java");

        //遍历（增强for）
        for(String s : set){
            System.out.println(s);
        }
    }
}
