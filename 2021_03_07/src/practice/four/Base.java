package practice.four;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Base {
    private String b = "base";

    public Base() {
        a();
    }
    public void a(){
        System.out.println(b);
    }
    static class B extends Base{
        private String b = "sub";
        public void a(){
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        Base b = new B();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        queue.add(1);
        queue.add(4);
        System.out.println(queue.poll());
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0,1);
        res.add(0,2);
        System.out.println(res);
    }

}
