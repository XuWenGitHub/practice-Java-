package practice.one;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        Map<String,String> map = new TreeMap<>();
        map.put(null,null);
        System.out.println(map);
        System.out.println(map.put(null,"s"));
        System.out.println(map);

    }
}
