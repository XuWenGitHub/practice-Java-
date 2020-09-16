package practice.one;

import java.util.*;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/15 17:04
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
//        int[][] arr = findContinuousSequence(9);
//        for(int[] ar:arr){
//            System.out.println(Arrays.toString(ar));
//        }

        //System.out.println(reverseWords("  hello world!  "));

        String str = "asdadas";
        char[] chars = str.toCharArray();
        System.out.println(String.valueOf(chars));
    }

    public int fib(int n) {
        return fib(new int[n+1],n);
    }
    public int fib(int[] fib,int n){
        if(n==0){
            return 0%1000000007;
        }
        if(n==1){
            return 1%1000000007;
        }
        if(fib[n]>0){
            return fib[n]%1000000007;
        }
        fib[n]= (fib(fib,n-1)+fib(fib,n-2))%1000000007;
        return (fib(fib,n-1)+fib(fib,n-2))%1000000007;
    }

    /*
    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int row = 0;
        int lie = matrix[0].length-1;
        while(row<matrix.length&&lie>=0){
            if(matrix[row][lie]<target){
                row++;
            }else if(matrix[row][lie]>target){
                lie--;
            }else{
                return true;
            }
        }
        return false;
    }

    /*
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
    */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res=-1;
        for(int num:nums){
            if(!set.add(num)){
                res = num;
                break;
            }
        }
        return  res;
    }

    /*
    输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        //构建一个双端队列，让其里面一直递减，保存的是窗口中最大的元素和后面比他小的
        Deque<Integer> deque = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];   //存储每次窗口移动时最大的元素，最后返回的值
        //i表示窗口的头，j表示窗口的尾部
        for (int j = 0, i = 1 - k; j < nums.length; j++, i++) {
            //窗口移动，deque的头是否是移动后前一个，如果是则移除deque的头部
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }
            //窗口移动，判断准备往双端队列尾部添加的nums[j]是否大于前面的，如果大于则删除前面的，直到不是最大的
            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
                deque.removeLast();
            }
            //窗口移动，添加元素
            deque.addLast(nums[j]);
            //j>=0时，表示窗口已经形成，给res数组，记录当前窗口中最大的值
            if (i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }



    public String reverseLeftWords(String s, int n) {
        //方法1：逆置字符串
        // s = reverseStr(s,0,n);
        // s = reverseStr(s,n,s.length());
        // s=reverseStr(s,0,s.length());
        // return s;

        //方法2：双倍串
        // int len = s.length();
        // s = s.concat(s);
        // char[] chars = s.toCharArray();
        // StringBuilder sb = new StringBuilder();
        // for(int i=n;i<len+n;i++){
        //     sb.append(chars[i]);
        // }
        // return sb.toString();

        //方法3：字符串分割
        return s.substring(n,s.length())+s.substring(0,n);
    }
    //逆置字符串的一部分,[start,end)
    public String reverseStr(String s,int start,int end){
        char[] chars = s.toCharArray();
        int left=start;
        int right = end-1;
        while(left<right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }


    public static String reverseWords(String s) {
        String[] sp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=sp.length-1;i>=0;i--){
            if(sp[i].equals("")){
                continue;
            }
            sb.append(sp[i]);
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
    public static int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }


}
