package practice.three;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/15 20:24
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
    有一堆石头，每块石头的重量都是正整数。
    每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且     x <= y。那么粉碎的可能结果如下：
    如果 x == y，那么两块石头都会被完全粉碎；
    如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
    最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
    */
    //构建一个大顶堆（优先级队列PriorityQueue）
    //把数组中的全部存进去，每次取出来都是最大的
    //每次取出来两个，然后比较，然后如果重量相等，不放
    //如果两个重量不相等，然后放进去两个重量差的绝对值
    //直到优先级队列个数为小于等于1
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = createBigHeap(stones);
        while(queue.size()>1){
            Integer num1 = queue.poll();
            Integer num2 = queue.poll();
            if(num1!=num2){
                queue.offer(Math.abs(num1-num2));
            }
        }
        if(queue.isEmpty()){
            return 0;
        }
        return queue.peek();
    }
    public PriorityQueue<Integer> createBigHeap(int[] arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        for(Integer element:arr){
            queue.offer(element);
        }
        return queue;
    }



    /*给定两个以升序排序的整形数组nums1和nums2，以及一个整数k
      然后返回分别从nums1一个数，nums2中一个数，构成的和，前k个最小的*/
    //构造一个大顶堆，用优先级队列即可,每次都可以取出最大值，个数为k个
    //然后遍历它们所有的组合
    //如果优先级队列queue为空，那么就直接添加进去，
    //如果不为空的话，那么看一下队列中最大的和当前遍历到的比较，如果队列中最大的比当前的大，那么就移除最大的，然后添加进去现在这个
    //就好比，一直维持了k个元素，每次可以取出最大的，如果有比最大的大，那么就删除最大的，然后添加新的，循环，直到遍历结束
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k,(o1, o2)->{
            return o2.get(0)+o2.get(1)-o1.get(0)-o1.get(1);
        });
        //遍历所有可能性
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                //如果满了，并且当前两个数加起来大于了大顶堆中最大的
                //那么就可以break，给的数组是有序的，那样后面的更大，就不需要判断了
                if(queue.size()==k&&(nums1[i]+nums2[j])>=(queue.peek().get(0)+queue.peek().get(1))){
                    break;
                }
                //走到这里有两种情况，第一种是优先级队列中元素不够K个，就直接添加
                //第二种：现在遍历的这个组合比优先级队列中最大的小，就需要移除优先级队列中最大的，然后再添加
                if(queue.size()==k){    //找到比优先级队列中最大的小的了
                    queue.poll();   //移除最大的，下面再加入新的
                }
                List<Integer> inner = new LinkedList<>();
                inner.add(nums1[i]);
                inner.add(nums2[j]);
                queue.offer(inner);
            }
        }
        //现在每次取出优先级队列的元素，每次取出来的都是最大的,每次插入头部即可
        List<List<Integer>> res = new LinkedList<>();
        while(!queue.isEmpty()){
            res.add(0,queue.poll());
        }
        return res;
    }
}
