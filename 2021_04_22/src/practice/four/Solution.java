package practice.four;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4};
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(arr));
    }
    /*
    dp[i]表示包含当前列矩阵的最大矩阵的面积
    leftDp[i]表示当前列 左边 比 当前列 低 的第一个下标
    rightDp[i]表示当前列 右边 比 当前列 低 的第一个下标
    例如：2 1 5 6 2 3
    leftDp[i]= -1 -1 1 2 1 4    （保存的下标,-1代表最左边的哨兵）
    rightDp[i]= 1  6 4 4 6 6
    dp[i] = (1-(-1)-1)*heights[0]

    单调递增栈解决leftDp
    2入栈 因为栈空所以leftDp[0]：-1
    1入栈 因为栈中2>1所以2出栈，然后栈空，所以leftDp[1]：-1
    5入栈 因为栈中1<5所以5直接入栈，1比5小，所以leftDp[2]：1
    6入栈 因为栈中5<6所以6直接入栈，5比6小，所有leftDp[3]：2
    */
    public int largestRectangleArea(int[] heights) {
        //dp[i]表示包含当前列矩形的最大面积
        int[] dp = new int[heights.length];
        //dp[i]表示当前行左边 比当前行的值小的第一个数的下标
        int[] leftDp = new int[heights.length];
        //dp[i]表示当前行右边 比当前行的值小的第一个数的下标
        int[] rightDp = new int[heights.length];
        Deque<Integer> stack = new LinkedList<>();  //单调递增栈
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            leftDp[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            rightDp[i] = stack.isEmpty()?heights.length:stack.peek();
            stack.push(i);
        }
        int res = 0;
        for(int i=0;i<dp.length;i++){
            dp[i] = (rightDp[i]-leftDp[i]-1)*heights[i];
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
