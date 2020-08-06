package practice.three;

import java.util.Scanner;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/7 1:14
 * Introduce:测试类
 */
public class Demo {
    /*
    实现一个简单的控制台版用户登陆程序,
    程序启动提示用户输入用户名密码. 如果用户名密码出错,
    使用自定义异常的方式来处理
     */
    public static boolean login(){
        String username = "admin";
        String password = "1234";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user = sc.nextLine();
        System.out.println("请输入密码：");
        String word = sc.nextLine();
        return user.equals(username) && word.equals(password);
    }
    public static void main(String[] args) {
        if(login()){
            System.out.println("登陆成功");
        }else{
            throw new LoginException("用户名or密码错误");
        }
    }
}
