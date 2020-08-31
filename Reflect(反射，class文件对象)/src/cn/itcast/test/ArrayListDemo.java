package cn.itcast.test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
* 我给你ArrayList<Integer>的一个对象，
* 我想在这个集合中添加一个字符串数据，如何实现呢？
* */
public class ArrayListDemo {
    public static void main(String[] args) throws Exception{
        //创建集合对象
        ArrayList<Integer> array = new ArrayList<>();

        Class c = array.getClass();
        Method m = c.getDeclaredMethod("add",Object.class);

        m.setAccessible(true);
        m.invoke(array,"hello");

        System.out.println(array);
    }
}
