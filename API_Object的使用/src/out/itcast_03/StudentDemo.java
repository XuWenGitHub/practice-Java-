package out.itcast_03;

/*
* public boolean equals(Object obj)指示其他某个对象是否与此对象“相等”。
*
* */
public class StudentDemo {
    public static void main(String[] args) {
        Student s1=new Student("徐文",21);
        Student s2=new Student("徐文",21);

        System.out.println(s1.equals(s2));
    }
}
