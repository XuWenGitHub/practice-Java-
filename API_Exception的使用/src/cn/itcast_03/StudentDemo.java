package cn.itcast_03;

import java.util.Scanner;

/*
* 自定义异常测试类
* */
public class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入成绩");
        int score = sc.nextInt();

        Teacher t = new Teacher();
        try {
            t.check(score);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
