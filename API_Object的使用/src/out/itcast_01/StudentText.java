package out.itcast_01;
/*
* 类 Object 是类层次结构的根类。
* 每个类都使用 Object 作为超类。
* 所有对象（包括数组）都实现这个类的方法。
* */
public class StudentText {
    public static void main(String[] args){
        Student s = new Student();
        System.out.println(s.hashCode());//764977973

        Student s2 = new Student();
        System.out.println(s2.hashCode());//381259350

        Student s3=s;
        System.out.println(s3.hashCode());//764977973
    }
}
