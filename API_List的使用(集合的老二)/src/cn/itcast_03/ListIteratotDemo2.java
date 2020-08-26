package cn.itcast_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
* 问题？
*       我有一个集合，如下，请问，我想判断里面有没有"world"这个元素，如果有，我就添加一个"javaee"元素，请写代码实现
*
* ConcurrentModificationException
* 产生的原因：
*       迭代器是依赖于集合而存在的，在判断成功后，
*       集合中新添加了元素，而迭代器确却不知道，所以就报错了，
*       这个错教并发修改异常
*       其实这个问题描述的是：迭代器遍历元素的时候，通过集合是不能修改元素的
*
* */
public class ListIteratotDemo2 {
    public static void main(String[] args) {
        //创建List集合对象
        List list = new ArrayList();
        //添加元素
        list.add("hello");
        list.add("world");
        list.add("java");

        //迭代器遍历
        //Iterator it = list.listIterator();
        //while (it.hasNext()){
            //String s = (String)it.next();
        //    if("world".equals(s)){
        //        list.add("javaee");
        //    }
        //}

        ListIterator lit = list.listIterator();
        while (lit.hasNext()){
            String s = (String)lit.next();
            if("world".equals(s)){
                lit.add("javaee");
            }
        }

        System.out.println("list:"+list);
    }

}
