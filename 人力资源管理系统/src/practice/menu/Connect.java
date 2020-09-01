package practice.menu;

import java.sql.*;

/**
 * @PackgeName: practice.menu
 * @ClassName: Connect
 * @Author: XuWen
 * Date: 2020/9/1 11:55
 * Introduce:   连接数据库
 */
public class Connect {



    private Connect(){
    }
    public static Connection getCoon(){
        Connection coon=null;
        try {
            String url = "jdbc:mysql://localhost:3306/hrdatabase?useSSL=false"; //前半部分默认，后面需要连接的数据库名
            String user = "root";   //数据库账号
            String password = "123456"; //数据库方法
            Class.forName("com.mysql.jdbc.Driver");      //5.1驱动导入
            coon = DriverManager.getConnection(url, user, password);  //连接数据库
            //System.out.println("连接成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return coon;
    }

    public static void close(){
        try {
            getCoon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
