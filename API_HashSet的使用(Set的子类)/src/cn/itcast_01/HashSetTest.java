package cn.itcast_01;

import java.util.HashSet;

/*
* HashSet集合存储自定义对象并遍历
*   如果对象的成员变量值相同即为同一个对象
* */
public class HashSetTest {
    public static void main(String[] args) {
        //创建集合对象
        HashSet<Dog> hs = new HashSet<Dog>();

        //创建集合元素
        Dog d1 = new Dog("饺子",20,"黄色",'公');
        Dog d2 = new Dog("饺子",20,"蓝色",'公');
        Dog d3 = new Dog("饺子",19,"黄色",'公');
        Dog d4 = new Dog("饺子",20,"绿色",'公');
        Dog d5 = new Dog("饺子",20,"黄色",'母');
        Dog d6 = new Dog("饺子",20,"黄色",'公');

        //添加集合元素
        hs.add(d1);
        hs.add(d2);
        hs.add(d3);
        hs.add(d4);
        hs.add(d5);
        hs.add(d6);

        //增强for遍历
        for(Dog d : hs){
            System.out.println(d.getName()+"---"+d.getAge()+"---"+d.getColor()+"---"+d.getSex());
        }
    }
}
