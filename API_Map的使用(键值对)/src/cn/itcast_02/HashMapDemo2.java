package cn.itcast_02;

import java.util.HashMap;
import java.util.Set;

public class HashMapDemo2 {
    public static void main(String[] args) {
        //创建集合对象
        HashMap<Integer,String> hm = new HashMap<Integer,String>();

        //创建并添加元素
//        Integer i = new Integer(27);
        /*Integer i = 27;
        String s = "林青霞";
        hm.put(i,s);*/

        hm.put(27,"林青霞");
        hm.put(30,"风清扬");
        hm.put(28,"刘毅");
        hm.put(29,"林青霞");

        //下面的写法是八进制，但是不能出现八进制以上的单个数据
        /*hm.put(003,"hello");
        hm.put(006,"hello");
        hm.put(007,"hello");
        hm.put(008,"林青霞");错误*/

        //遍历
        Set<Integer> set = hm.keySet();
        for(Integer i:set){
            System.out.println(i+"---"+hm.get(i));
        }
    }
}
