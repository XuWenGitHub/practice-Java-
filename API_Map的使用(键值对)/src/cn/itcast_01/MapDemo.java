package cn.itcast_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        //创建集合对象
        Map<String,String> map = new HashMap<String,String>();

        //创建元素并添加到集合
        map.put("杨过","小龙女");
        map.put("郭靖","黄蓉");
        map.put("杨康","穆念慈");
        map.put("陈玄风","梅超风");

        Set<String> set1 = map.keySet();
        for(String key:set1){
            String value=map.get(key);
            System.out.println(key+"---"+value);
        }

        Set<Map.Entry<String,String>> set = map.entrySet();
        for(Map.Entry<String,String> me:set){
            String key = me.getKey();
            String value = me.getValue();
            System.out.println(key+"---"+value);
        }
//        //获取所有键值对对象的集合
//        Set<Map.Entry<String,String>> set = map.entrySet();
//        //遍历键值对对象的集合，得到每一个键值对对象
//        for(Map.Entry<String,String> me:set){
//            //根据键值对对象获取键和值
//            String key = me.getKey();
//            String value = me.getValue();
//            System.out.println(key+"---"+value);
//        }
    }
}
