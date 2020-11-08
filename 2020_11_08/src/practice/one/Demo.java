package practice.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/11/8 8:56
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,2,3,4,5,6,3,4,5,6,7,8,9,10};
        System.out.println(find(arr));
    }
    //返回一个数组中任意连续子序列（且值不能重复）中最长的长度
    public static int find(int[] arr){
        Map<Integer,Integer> numToIndex = new HashMap<>();
        int len = 0;
        for(int start=0,end=0;end<arr.length;end++){
            if(numToIndex.containsKey(arr[end])){
                start = Math.max(start,numToIndex.get(arr[end]));
            }
            len = Math.max(len,end-start+1);
            numToIndex.put(arr[end],end+1);
        }
        return len;
    }
}
