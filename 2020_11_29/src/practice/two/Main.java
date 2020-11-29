package practice.two;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[4];
        int index=0;
        String[] split = str.split(" ");
        for(String s:split){
            arr[index++] = Integer.parseInt(s);
        }
        int a = (arr[0]+arr[2])/2;
        int b = arr[2]-a;
        int c = b-arr[1];

        if((a-b)==arr[0]&&(b-c)==arr[1]&&(a+b)==arr[2]&&(b+c)==arr[3]){
            System.out.println(a+" "+b+" "+c);
            return;
        }


        System.out.println("No");
    }
}
