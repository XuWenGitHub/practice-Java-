package task;

import java.util.Scanner;

/*
测试类
 */
public class UserTest {
    public static void main(String[] args) {
        UserDao ud = new UserDaoImpl(); //这就是登录和注册功能的具体实现类对象
        Scanner scInt =new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        while (true){
            System.out.println("----------------欢迎光临----------------");
            System.out.println("1 登录");
            System.out.println("2 注册");
            System.out.println("3 退出");
            System.out.println("请输入您的选择");
            int choose=scInt.nextInt();
            switch (choose){
                case 1:
                    for(int i=0;i<3;i++) {
                        System.out.println("----------------登录界面----------------");
                        System.out.println("请输入用户名：");
                        String username = scStr.nextLine();
                        System.out.println("请输入密码：");
                        String password = scStr.nextLine();
                        int count = 0;
                        boolean flag = ud.isLogin(username, password);
                        if (flag) {
                            System.out.println("登陆成功");
                            System.exit(1);
                        } else {
                            System.out.println("登陆失败");
                            if(i==2){
                                System.out.println("已经三次失败，即将退出程序");
                                System.exit(1);
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("----------------注册界面----------------");
                    System.out.println("请输入用户名：");
                    String username = scStr.nextLine();
                    System.out.println("请输入密码：");
                    String password = scStr.nextLine();
                    User user = new User(username,password);
                    ud.regist(user);
                    System.out.println("注册成功");
                    break;
                case 3:
                    System.exit(1);
                    break;
            }
        }
    }
}
