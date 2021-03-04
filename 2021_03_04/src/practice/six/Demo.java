package practice.six;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        System.out.println(deque.peek());
        Integer integer = deque.removeFirst();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int t = 0;
        //每次存比最大值大的数，和比最大值小的数
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            if(i>0&&!deque.isEmpty()&&deque.peek()==nums[i]){
                deque.removeFirst();
            }
            while(!deque.isEmpty()&&deque.getLast()<nums[j]){
                deque.removeLast();
            }
            deque.add(nums[j]);
            if(i>=0&&!deque.isEmpty()){
                res[t++] = deque.peek();
            }
        }
        return res;
    }

    //构成一个[left,right)的滑动窗口
    public int[][] findContinuousSequence(int target) {
        int left = 0;
        int right = 1;
        List<int[]> list = new ArrayList<>();
        int sum = left;
        while (left <= (target / 2)) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] ints = new int[right - left];
                int t = 0;
                for (int i = left; i < right; i++) {
                    ints[t++] = i;
                }
                list.add(ints);
                sum += right;
                right++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
