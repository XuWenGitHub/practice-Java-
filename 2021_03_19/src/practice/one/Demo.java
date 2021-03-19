package practice.one;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void a(){
        System.out.println("sad");
    }
    public final void b(){
        System.out.println("b");
    }
}
class D extends Demo{
    public static void a(){
        System.out.println("asd");
    }

    public static void main(String[] args) {
        String s= "[20,18,29,17,22,21,30,19]";
        int num = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='0'&&c<='9'){
                num = num*10+(c-'0');
            }else if(c==','){
                list.add(num);
                num = 0;
            }
        }
        list.add(num);
        System.out.println(list);
        int[] dp = new int[list.size()];
        dp[0] = 0;
        int minMoney = list.get(0);
        int minIndex = 0;
        int res = 0;    //表示最大利润
        int right = -1;  //表示最大利润时候的下标
        int left = -1;
        for(int i = 1;i<dp.length;i++){
            int val = list.get(i);
            if(val<=minMoney){
                minMoney = val;
                minIndex = i;
            }else{
                dp[i] = val-minMoney;
            }
            if(dp[i]>res){
                res = dp[i];
                right = i;
                left = minIndex;
            }
        }
        System.out.println(list.subList(left,right+1));

    }

}
