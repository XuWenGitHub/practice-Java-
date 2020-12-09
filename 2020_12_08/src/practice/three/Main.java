package practice.three;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n==1){
                System.out.println("1");
            }else{
                System.out.println(GetSequeOddNum(n));
            }
        }
    }
    public static String GetSequeOddNum(int m){
        int fac = fact(m-1);
        int first = (int)Math.pow(2,fac)+1;
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        for(int i=1;i<m;i++){
            first+=2;
            sb.append("+").append(first);
        }
        return sb.toString();
    }
    public static int fact(int n){
        int res = 1;
        for(int i=n;i>1;i--){
            res+=i;
        }
        return res;
    }
}
