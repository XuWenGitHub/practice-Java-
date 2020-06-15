package cn.itcast_02;

import java.util.Scanner;

/*
* 校验QQ号
*           A：全为数字
*           B：不能以0开头
*           C：个数为5位到15位
*
* 分析：
*       A：键盘录入一个QQ号码
*       B：写一个功能实现校验
*       C：调用功能，输出结果
* */
public class RegexDemo {
    public static void main(String[] args) {
        //创建键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的QQ号码：");
        String qq = sc.nextLine();

        //调用功能，输出结果
        System.out.println("checkQQ:"+checkQQ(qq));
    }

    //一个功能实现QQ校验
    public static boolean checkQQ(String qq){
        boolean flag = true;

        //校验长度
        if(qq.length()>=5&&qq.length()<=15){
            //0不能开头
            if(!qq.startsWith("0")){
                //必须是数字
                char[] array = qq.toCharArray();
                for(int i=0;i<array.length;i++){
                    if(!Character.isDigit(array[i])){
                        flag = false;
                        break;
                    }
                }
            }else {
                flag = false;
            }
        }else {
            flag = false;
        }

        return flag;
    }
}
