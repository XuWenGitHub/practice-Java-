package practice.two;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] nums = new int[10];
            for(int i=0;i<10;i++){
                int val = sc.nextInt();
                nums[val]+=1;
            }
            StringBuilder sb = null;
            boolean flag = true;
            for(int i=1;i<nums.length;i++){
                if(flag&&sb!=null){
                    while(nums[0]!=0){
                        sb.append(0);
                        nums[0]-=1;
                    }
                    flag = false;
                }
                while(nums[i]!=0){
                    if(sb==null){
                        sb = new StringBuilder();
                    }
                    sb.append(i);
                    nums[i]-=1;
                }
            }
            System.out.println(sb.toString());
        }
    }
}