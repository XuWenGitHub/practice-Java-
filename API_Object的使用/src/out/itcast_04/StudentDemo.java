package out.itcast_04;

public class StudentDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        /* 创建学生对象 */
        Student s=new Student();
        s.setName("徐文");
        s.setAge(20);

        /* 克隆学生对象 */
        Object obj = s.clone();
        Student s2=(Student)obj;
        System.out.println("---------");

        System.out.println(s.getName()+"---"+s.getAge());
        System.out.println(s2.getName()+"---"+s2.getAge());

        /* 以前做法 */
        Student s3=s;
        System.out.println(s3.getName()+"---"+s3.getAge());

        System.out.println("-------------------------");
        
        /* 其实是有区别的 */
        s3.setName("文尚洁");
        s3.setAge(46);
        System.out.println(s.getName()+"---"+s.getAge());
        System.out.println(s2.getName()+"---"+s2.getAge());
        System.out.println(s3.getName()+"---"+s3.getAge());
    }
}
