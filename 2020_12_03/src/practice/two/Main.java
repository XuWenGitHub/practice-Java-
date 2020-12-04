package practice.two;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int first = 0;
        int second= 1;
        int three = first+second;

        int sub = Integer.MAX_VALUE;    //差值
        while(true){
            three = first+second;
            if(Math.abs(num-three)>=sub){
                break;
            }else{
                sub = Math.abs(num-three);
                first = second;
                second = three;
            }
        }
        System.out.println(sub);
    }
}
