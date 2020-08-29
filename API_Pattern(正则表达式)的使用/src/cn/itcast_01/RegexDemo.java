package cn.itcast_01;

import java.util.Scanner;

/*
* 需求：
*      判断手机号码是否满足要求
*
* 分析：
*       A:键盘录入手机号码
*       B：定义手机号码的规则
*           18909153042
*           13688886868
*           13866668888
*           13456789012
*           13123456789
*           18638833883
*       C：调用功能，判断即可
*       D：输出结果
* */
public class RegexDemo {
    public static void main(String[] args) {
        //键盘录入手机号码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的手机号码：");
        String phone = sc.nextLine();

        //定义手机号码的规则
        String regex = "1[38]\\d{9}";//第一位是1，第二位是3或者8，后面9位位0-9随便数字

        //调用功能，判断即可
        boolean flag = phone.matches(regex);
        System.out.println("flag:"+flag);
    }
}
