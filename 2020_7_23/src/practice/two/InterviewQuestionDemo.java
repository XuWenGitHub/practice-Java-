package practice.two;

import java.math.BigInteger;

/**
 * 每日一道面试题
 */
public class InterviewQuestionDemo {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(Integer.MAX_VALUE);//1534236469
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.parseInt("1231"));
    }
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else if(x==0){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        int copyX=x;
        while(copyX!=0){
            sb.append(copyX%10);
            copyX/=10;
        }
        if((Integer.parseInt(sb.toString()))==x){
            return true;
        }else{
            return false;
        }
    }


    //给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    //例如123->321    -321->-123  120->21
    //注意：一定要判断，是否x反转一下，就超过了int类型的最大值,或者超过了int类型的最小值
    public static int reverse(int x) {
        int value=0;    //存放最后的值的value
        if(x==0){
            return 0;
        }
        int copyX=x;
        int digit=0;
        while(copyX!=0){
            digit++;
            copyX/=10;
        }
        for(int i=digit-1;i>=0;i--){
            long a=x%10;  //取出每一位，例如123，先取出3
            x/=10;
            long flagNum=a*(long)Math.pow(10,i)+value;
            if(flagNum>Integer.MAX_VALUE||flagNum<Integer.MIN_VALUE){
                return 0;  //表示异常，超过int的最大值的
            }
            value+=(a*(int)Math.pow(10,i));
        }
        return value;
    }



    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * @param nums 整数数组
     * @param target 目标值
     * @return 存放数组下标的数组
     */
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        boolean flag=false;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    flag=true;
                    arr[0]=i;
                    arr[1]=j;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        return arr;
    }
}
