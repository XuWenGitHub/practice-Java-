package practice.three;

import java.util.*;
class A{
    static class Main{

    }
}
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("bye")) {
            String N = sc.nextLine();

            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < N.length(); i++) {
                int val = N.charAt(i) - '0';
                if (map.containsKey(val)) {
                    map.put(val, map.get(val) + 1);
                } else {
                    map.put(val, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(key + ":" + value);
            }
        }
    }

}
