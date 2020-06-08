package cn.itcast_01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
* 使用ArrayList存储字符串并遍历
* */
public class ArrayListDemo {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList array = new ArrayList();

        //创建元素对象，并添加元素
        array.add("hellpo");
        array.add("2");
        array.add("3");

//        for(Object obj:array){
//            String s = (String)obj;
//            System.out.println(s);
//        }
//        Object[] arr = array.toArray();
//        for(int i=0;i<arr.length;i++){
//            String s1 = (String)arr[i];
//            System.out.println(s1);
//        }

//        for(Integer s:array){
//            System.out.println(s);
//        }

        //遍历存储字符串的ArrayList集合
        ListIterator lit = array.listIterator();
        while (lit.hasNext()){
            String s = (String)lit.next();
            System.out.println(s);
        }
//
//        //所有集合遍历都可以
//        Iterator it = array.iterator();
//        while (it.hasNext()){
//            String ss = (String)it.next();
//            System.out.println(ss);
//        }

    }
}
