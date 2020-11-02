package practice.one;

import java.util.*;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/11/1 22:28
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
    动态规划解决连续子数组的最大和
    动态规划数组，每次保存当前[0,i]中连续子数组的最大和
    注意！！！：但是每次都必须包含arr[i]因为不然后面就不能达成连续子数组了
    每个dp[i]必须包含nums[i]，因为不然就不能保证连续了
    当 dp[i - 1] > 0 dp[i−1]>0 时：执行 dp[i] = dp[i-1] + nums[i]
当dp[i−1]≤0 时：执行 dp[i] = nums[i]dp[i]=nums[i]
    */
    public int maxSubArray(int[] nums) {
        //动态规划数组，求出包含当前数字中最大子数组的和
        //必须包含当前nums[i]，不然就不能满足连续了
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int dpIndex = 1;    //动态规划数组的下标
        int res = dp[0];    //表示最后返回的结果
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]>=0){
                dp[i] = dp[i-1]+nums[i];
            }else{
                dp[i] = nums[i];
            }
            //判断dp[i]和res比较，大的放入res
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    //最小的k个数
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0){
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1,o2)->{
            return o2-o1;
        });
        for(int i=0;i<arr.length;i++){
            if(maxHeap.size()<k){
                maxHeap.add(arr[i]);
            }else{
                Integer maxValue = maxHeap.peek();
                if(maxValue>arr[i]){
                    maxHeap.poll();
                    maxHeap.add(arr[i]);
                }
            }
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = maxHeap.poll();
        }
        return res;
    }

    //数组中出现次数超过一半的数字
    //先假设第一个是众数，然后遇到相同的，res+=1，遇到不相同的res-=1
    //当res==0时，换下一个为众数，
    //循环如此，直到把nums遍历结束，最后那个众数，一定是众数
    public int majorityElement(int[] nums) {
        int mode = nums[0];
        int res = 1;
        for(int i=1;i<nums.length;i++){
            if(res==0){
                res = 1;
                mode=nums[i];
            }else{
                if(nums[i]==mode){
                    res+=1;
                }else{
                    res-=1;
                }
            }
        }
        return mode;
    }

    //前k个高频单词
    //先遍历字符数组，然后把每个单词出现的次数存入MAP里面
    //然后定义一个大顶堆，然后把Map存的键值对，全存入大顶堆
    //最后定义res集合，然后从大顶堆优先级队列中去k个
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> strToNum = new HashMap<>();
        for(String s:words){
            if(strToNum.containsKey(s)){
                strToNum.put(s,strToNum.get(s)+1);
            }else{
                strToNum.put(s,1);
            }
        }
        //构造一个大顶堆
        PriorityQueue<Element> heap = new PriorityQueue<>((o1, o2)->{
            int sum = o2.sum-o1.sum;
            if(sum==0){
                return o1.str.compareTo(o2.str);
            }else{
                return sum;
            }
        });
        //把Map中的全部存入heap
        for(Map.Entry<String,Integer> entry:strToNum.entrySet()){
            heap.add(new Element(entry.getValue(),entry.getKey()));
        }
        //定义res
        List<String> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(heap.poll().str);
        }
        return list;
    }
    class Element{
        int sum;
        String str;
        public Element(int sum,String str){
            this.sum = sum;
            this.str = str;
        }
    }
}
