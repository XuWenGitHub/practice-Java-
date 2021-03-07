package practice.four;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class Solution {
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(arr,4));
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        //维护优先级队列中一共4个数字
        for(int element:input){
            if(queue.size()==k){
                if(queue.peek()>element){
                    queue.poll();
                    queue.add(element);
                }
            }else{
                queue.add(element);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(0,queue.poll());
        }
        return res;
    }
}
