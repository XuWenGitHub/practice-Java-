package practice.one;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ch = sc.next();
        method(n,ch);
    }
    public static void method(int n,String ch){
        for(int i=1;i<=Math.round(n*0.5);i++){
            for(int j=0;j<n;j++){
                if(i==1||i==Math.round(n*0.5)){
                    System.out.print(ch);
                }else{
                    if(j==0||j==n-1){
                        System.out.print(ch);
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}