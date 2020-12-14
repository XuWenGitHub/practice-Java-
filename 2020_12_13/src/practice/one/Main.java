package practice.one;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
//        Integer a = Integer.valueOf(59);
//        Integer b = new Integer(59);
//        Integer i = 59;
//        int j = 59;
//        System.out.println(a==b);
//        System.out.println(j==b);
//        System.out.println(i==a);
//        System.out.println(i==j);
        try {
            Class c = Class.forName(args[0]);
            Method[] m = c.getDeclaredMethods();
            for(int i=0;i<m.length;i++){
                System.out.println(m[i].toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
