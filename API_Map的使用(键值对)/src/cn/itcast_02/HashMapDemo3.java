package cn.itcast_02;

import java.util.HashMap;
import java.util.Set;

/*
* 键值对（String,Student）
*          学号   学生对象
* */
public class HashMapDemo3 {
    public static void main(String[] args) {
        //创建集合对象
        HashMap<String,Student> hm=new HashMap<String, Student>();

        //创建学生对象
        Student s1 = new Student("周星驰",58);
        Student s2 = new Student("刘德华",55);
        Student s3 = new Student("梁朝伟",54);
        Student s4 = new Student("刘嘉玲",50);

        //添加元素
        hm.put("9527",s1);
        hm.put("9522",s2);
        hm.put("9524",s3);
        hm.put("9525",s4);

        //遍历
        Set<String> set = hm.keySet();
        for(String s:set){
            Student value =hm.get(s);
            System.out.println(s+"---"+value.getName()+"---"+value.getAge());
        }
    }
}
