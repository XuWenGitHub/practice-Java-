package cn.itcast_10;

import java.util.Random;
import java.util.Scanner;

/*
* 猜数字小游戏
* */
public class GuessNumber {

    private GuessNumber() {
    }

    public static void start(){
        Random r = new Random();
        int num1 = r.nextInt(100)+1;
        //System.out.println(num1);

        while (true) {
            System.out.println("请猜一个1-100的数字:");
            Scanner sc = new Scanner(System.in);
            int num2 = sc.nextInt();

            if(num2>num1){
                System.out.println("您猜的数字"+num2+"大了");
            }else if (num2<num1){
                System.out.println("您猜的数字"+num2+"小了");
            }else{
                System.out.println("恭喜你，猜对了");
                break;
            }
        }

    }
}
