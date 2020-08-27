package cn.itcast_03;

import java.util.LinkedHashMap;
import java.util.Set;

/*
* LinkdeHashMap:是Map接口的哈希表和链接列表实现
*               具有可预知的迭代顺序
* */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        //创建集合对象
        LinkedHashMap<String,String> lhm = new LinkedHashMap<String, String>();

        //创建并添加元素
        lhm.put("2345","hello");
        lhm.put("1234","world");
        lhm.put("3456","java");
        lhm.put("1234","javaee");
        lhm.put("3456","android");

        //遍历
        Set<String> set = lhm.keySet();
        for(String key:set){
            String value = lhm.get(key);
            System.out.println(key+"---"+value);
        }
    }
}
