package out.cast_01;

import out.cast_02.Student;

public class StudentDemo {
    public static void main(String[] args){
        Student s = new Student();
        s.setName("徐文");
        s.setAge(20);
        System.out.println(s.getName()+"---"+s.getAge());
        s.show();
        System.out.println("------------------");
        Student s2=new Student("徐文",20);
        System.out.println(s2.getName()+"---"+s2.getAge());
        s2.show();
    }
}
