package practice.two;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //String str = sc.nextLine();
        //String[] split = str.split(" ");
        //int num1 = Integer.parseInt(split[0]);
        //int num2 = Integer.parseInt(split[1]);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(minMul(num1,num2));
    }
    public static int minMul(int num1,int num2){
        int min = Math.min(num1,num2);    //最小公倍数
        int temp=2;    //下一次是两个数小的多多少倍
        int mul = min;    //记录小的
        while(true){
            if((min%num1)==0&&(min%num2)==0){
                return min;
            }
            min = mul*temp;    //更换最小公倍数
            temp++;
        }
    }
}
