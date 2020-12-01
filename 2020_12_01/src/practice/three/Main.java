package practice.three;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        int num = 0;
        List<Integer> list = new ArrayList<>();
        while(sc.hasNext()){
            int val = sc.nextInt();
            list.add(val);
        }
        int n = list.get(list.size()-1);    //代表多少个最小的
        list.remove(list.size()-1);
        for(Integer i:list){
            if(num==n){
                int v = queue.peek();
                if(i<v){
                    queue.poll();
                    queue.offer(i);
                }
            }else{
                num++;
                queue.offer(i);
            }
        }
        Deque<Integer> stack = new LinkedList<>();
        while(!queue.isEmpty()){
            stack.push(queue.poll());
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
