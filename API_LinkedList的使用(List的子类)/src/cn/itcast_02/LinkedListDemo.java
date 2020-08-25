package cn.itcast_02;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {
        //创建集合对象
        LinkedList link =new LinkedList();

        //创建学生对象
        Student s1 = new Student("徐文",20);
        Student s2 = new Student("徐文文",20);

        //添加对象
        link.add(s1);
        link.add(s2);

        //遍历
        ListIterator lit = link.listIterator();
        while (lit.hasNext()){
            Student ss = (Student)lit.next();
            System.out.println(ss.getName()+"---"+ss.getAge());
        }

        System.out.println("-------------");

        for(int i=0;i<link.size();i++){
            Student sss = (Student)link.get(i);
            System.out.println(sss.getName()+"---"+sss.getAge());
        }
    }
}
