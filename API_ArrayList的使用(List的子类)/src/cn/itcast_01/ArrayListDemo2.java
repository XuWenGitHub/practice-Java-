package cn.itcast_01;

import java.util.ArrayList;
import java.util.ListIterator;

/*
* ArrayList存储对象，并遍历
* */
public class ArrayListDemo2 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Student> array =new ArrayList<>();

        //创建学生对象
        Student s1 = new Student("徐文",20);
        Student s2 = new Student("武松",30);
        Student s3 = new Student("宋江",35);
        Student s4 = new Student("鲁智深",45);

        //添加学生对象到集合
        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);

        //遍历
        ListIterator lit = array.listIterator();
        while (lit.hasNext()){
            Student ss = (Student)lit.next();
            System.out.println(ss.getName()+"---"+ss.getAge());
        }

        System.out.println("--------------");

        for(int i=0;i<array.size();i++){
            Student sss = (Student)array.get(i);
            System.out.println(sss.getName()+"---"+sss.getAge());
        }
    }
}
