package cn.itcast_01;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        //用ArrayList存储字符串元素，并遍历，用泛型改进代码

        //创建集合对象
        ArrayList<String> array = new ArrayList<String>();

        //创建字符串元素，并存入集合
        array.add("hello");
        array.add("world");
        array.add("java");

        //遍历
        ListIterator<String> lit = array.listIterator();
        while (lit.hasNext()){
            String s = lit.next();
            System.out.println(s);
        }
        System.out.println("-------------");

        for(int i=0;i<array.size();i++){
            String ss = array.get(i);
            System.out.println(ss);
        }
    }
}
