package out.itcast_02;

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.hashCode());
        System.out.println(s.getClass().getName());//out.itcast_02.Student
        System.out.println("-------------");
        System.out.println(s.toString());//返回该对象的字符串表示

        System.out.println(s);
    }
}
