package cn.itcast_02;

import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        //创建集合对象
        HashMap<String,String> hm = new HashMap<String, String>();

        //创建元素并添加元素
        /*String key1 = "it001";
        String value1 = "马云";
        hm.put(key1,value1);*/

        hm.put("it001","马云");
        hm.put("it003","马化腾");
        hm.put("it004","乔布斯");
        hm.put("it005","张朝阳");
        hm.put("it002","求伯君");
        hm.put("it001","马超");

        //遍历
        Set<String> set = hm.keySet();
        for(String s:set){
            /*String ss = hm.get(s);*/
            System.out.println(s+"---"+hm.get(s));
        }
    }
}
