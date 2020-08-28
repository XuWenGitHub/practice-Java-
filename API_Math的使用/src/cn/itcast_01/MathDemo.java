package cn.itcast_01;

import java.util.Scanner;

/*
* 需求：请设计一个方法，可以实现获取任意范围内的随机数
*
* 分析：
*       A:键盘录入两个数据
*           int start;
*           int end;
*       B:想办法获取在start到end之间的随机数
*           我写一个功能实现这个效果，得到一个随机数。（int）
*       C：输出这个随机数
* */
public class MathDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入开始数：");
        int start = sc.nextInt();
        System.out.println("请输入结束数：");
        int end = sc.nextInt();


        for(int i=0;i<100;i++) {
            //调用功能
            int numebr = getRandom(start, end);

            //输出结果
            System.out.println(numebr);
        }
    }

    //一个可以可以生成任意范围的随机数方法
    public static int getRandom(int start,int end){
        //回想我们讲过的1-100之间的随机数
        //int number = (int)((Math.random()*100)+1);
        //int number = (int)((Math.random()*end)+start);
        //发现问题了
        int number = (int)((Math.random()*(end-start+1))+start);
        return number;
    }
}
