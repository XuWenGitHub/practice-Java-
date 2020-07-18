package test;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public GuessNumber() {

    }
    //必须创建猜数字游戏对象，然后用对象，调用start方法
    public void start(){
        //先生成一个随机数
        Random random = new Random();
        int num = random.nextInt(100)+1;
        //System.out.println(num);
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag){
            System.out.println("请输入猜测的数字");
            int guessNum = sc.nextInt();
            if(guessNum>num){
                System.out.println(guessNum+"大了");
            }else if(guessNum<num){
                System.out.println(guessNum+"小了");
            }else if(guessNum==num){
                System.out.println("恭喜你，猜对了");
                System.out.println("是否还要玩一次？");
                System.out.println("  1：再来一次  2:不玩了");
                int i=sc.nextInt();
                if(i==2){
                    flag=false;
                }
            }else {
                System.out.println("bug!!!!");
            }
        }
    }
}
