package cn.itcast_01;

/*
* 集合的遍历，其实就是一次获取集合中的每一个元素
*
* Object[] toArray():把集合转成数组，可以实现集合的遍历
* */

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo3 {
    public static void main(String[] args) {
        //创建集合对象
        Collection c1 = new ArrayList();

        //添加元素
        c1.add("hello");
        c1.add("world");
        c1.add("java");

        //遍历
        Object[] objs = c1.toArray();
        for(int i=0;i<objs.length;i++){
            //System.out.println(objs[i]);
            //String.valueOf(objs[i]).length();

            //第一种方法：
            //System.out.println(objs[i]+"---"+String.valueOf(objs[i]).length());

            //第二种方法：向下转型
            String s = (String) objs[i];
            System.out.println(s+"---"+s.length());
        }

    }
}
