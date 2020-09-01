import practice.menu.Connect;
import practice.menu.JDBC;
import practice.menu.Menu;

import java.sql.*;
import java.util.Scanner;

import static practice.menu.Menu.startMenu;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: Test
 * @Author: XuWen
 * Date: 2020/9/1 11:59
 * Introduce:
 */
public class Test {
    public static boolean login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入人力资源管理系统账号=>");
        String username = sc.nextLine();
        System.out.println("请输入人力资源管理账号密码=>");
        String password = sc.nextLine();

        //现在从JDBC中用户登录表（login）中获取数据验证
        Connection coon = Connect.getCoon();
        String sql="select * from login;";
        try{
            Statement sta = (Statement)coon.createStatement();
            ResultSet rs = (ResultSet)sta.executeQuery(sql);
            while(rs.next()) {
                String name = rs.getString("username");
                String word = rs.getString("password");
                if(name.equals(username)&&word.equals(password)) {
                    return true;
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        //Connect.getCoon();
        //测试账号登录
        if(login()){
            System.out.println("登陆成功");
        }else{
            System.out.println("账号或者密码错误");
            System.exit(1);
        }

        boolean flag = true;    //第一层循环控制
        while(flag){
            Menu.startMenu();   //增删改查员工
            System.out.println("请选择=>");
            int chose = scInt.nextInt();
            switch (chose){
                case 1: //添加员工
                    System.out.println("请输入新员工的编号");
                    int employeeNo=scInt.nextInt();
                    System.out.println("请输入新员工的职位");
                    String title = scStr.nextLine();
                    System.out.println("请输入新员工的名字");
                    String employeeName = scStr.nextLine();
                    System.out.println("请输入新员工的家庭地址");
                    String employeeAddress = scStr.nextLine();
                    System.out.println("请输入新员工的性别");
                    String employeeSex = scStr.nextLine();
                    System.out.println("请输入新员工的资薪");
                    int employeeSalary = scInt.nextInt();
                    System.out.println("请输入新员工的部门编号");
                    int departmentNo = scInt.nextInt();
                    JDBC.add(employeeNo,title,employeeName,employeeAddress,employeeSex,employeeSalary,departmentNo);
                    break;
                case 2: //删除员工
                    System.out.println("请输入需要删除的员工的编号");
                    JDBC.delete(scInt.nextInt());
                    break;
                case 3: //查询员工
                    System.out.println("请输入需要查询员工的id");
                    if(!JDBC.search(scInt.nextInt(),true)){
                        System.out.println("没有找到该员工");
                    }
                    break;
                case 4: //修改员工信息
                    System.out.println("请输入需要修改的属性名");
                    String property = scStr.nextLine();
                    System.out.println("请输入需要修改的值");
                    String updateProperty = scStr.nextLine();
                    System.out.println("需要修改的属性名的employeeNo的是多少");
                    int employeeNo1 = scInt.nextInt();
                    JDBC.update(property,updateProperty,employeeNo1);
                    break;
                case 5:
                    JDBC.list();
                    break;
                case 0: //退出系统
                    flag=false;
                    break;
            }
        }

        //System.out.println(JDBC.search(1));
        //JDBC.add(1,"manage","徐文","西安","男",10000,1);
        //JDBC.delete(1);
    }
}
