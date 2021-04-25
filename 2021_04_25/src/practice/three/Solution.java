package practice.three;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{9,7,6,4,3,2};
        Solution solution = new Solution();
        System.out.println(solution.maxNum(arr));
    }
    LinkedList<Integer> num1;
    LinkedList<Integer> num2;
    int res;
    public int maxNum(int[] arr){
        num1 = new LinkedList<>();
        num2 = new LinkedList<>();
        num1.addLast(arr[0]);
        num2.addLast(arr[1]);
        res = 0;
        dfs(arr,2);
        return res;
    }
    public void dfs(int[] arr,int index){
        if(index==arr.length){
            int one=0;
            int two = 0;
            for(Integer i:num1){
                one*=10;
                one+=i;
            }
            for(Integer i:num2){
                two*=10;
                two+=i;
            }
            res = Math.max(res,one*two);
            return;
        }

        if(num1.size()==num2.size()){
            num1.addLast(arr[index]);
            dfs(arr,index+1);
            num1.removeLast();

            num2.addLast(arr[index]);
            dfs(arr,index+1);
            num2.removeLast();
        }else{
            if(num1.size()<num2.size()){
                num1.addLast(arr[index]);
                dfs(arr,index+1);
                num1.removeLast();
            }else{
                num2.addLast(arr[index]);
                dfs(arr,index+1);
                num2.removeLast();
            }
        }
    }
}
