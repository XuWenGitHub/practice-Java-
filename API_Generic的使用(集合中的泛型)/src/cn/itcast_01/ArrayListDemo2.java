package cn.itcast_01;

import java.util.ArrayList;
import java.util.ListIterator;

/*
* 需求：存储自定义对象并遍历。
* */
public class ArrayListDemo2 {
    public static void main(String[] args) {
        //定义集合对象
        ArrayList<Student> array = new ArrayList<Student>();

        //创建学生对象
        Student s1 = new Student("徐文",20);
        Student s2 = new Student("徐文文",20);
        Student s3 = new Student("徐文阿达",20);

        //添加学生对象到集合中
        array.add(s1);
        array.add(s2);
        array.add(s3);

        //遍历
        ListIterator<Student> lit = array.listIterator();
        while (lit.hasNext()){
            Student ss = lit.next();
            System.out.println(ss.getName()+"---"+ss.getAge());
        }
        System.out.println("-------------");

        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getName()+"---"+s.getAge());
        }
    }
}
