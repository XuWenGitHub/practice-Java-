package practice.one;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {
    static Demo d;
    public static void main(String[] args) {
        synchronized (Demo.class){
            System.out.println("sa");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<>();
        //concurrentHashMap.put(null,"a");
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(null,"asd");
        System.out.println(hashMap);
    }
}
