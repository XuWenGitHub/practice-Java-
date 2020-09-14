package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/13 8:54
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        Demo.<Integer>method(1,2);
        method("S","asdas");
        Integer i=100;
        method1(i);
        //i=200;
        System.out.println(i);
        String s = Long.toOctalString(19);
        long a = Long.parseLong(s,8);
        System.out.println(s);
        System.out.println(a);
    }
    public static void method1(Integer i){
        i= 200;
    }
    public static <T> void method(T a,T b){

    }
}
