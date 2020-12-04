package practice.one;

import java.util.Map;
import java.util.TreeMap;

public class Demo {
    public static void main(String[] args) {
//        Thread t = new Thread(){
//            @Override
//            public void run() {
//                pong();
//            }
//        };
//        t.run();
//        System.out.println("ping");
        Map<Integer,Integer> map = new TreeMap<>();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map);
        long n = 10;
        int a = (int) (n%10);
    }
    static void pong(){
        System.out.println("pong");
    }
}
