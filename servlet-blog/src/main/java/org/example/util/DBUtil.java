package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/servlet_blog?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8&useSSL=false";

    private static final DataSource dataSource = new MysqlDataSource();

    /**
     * 工具类提供数据库JDBC操作
     * 步骤：1.static代码块出现错误，NoClassDefFoundError表示类可以找到，但是类加载失败，无法运行
     *        ClassNotFoundException：找不到类
     *      2.学了多线程之后，可能会采取双重校验锁的单例模式来创建DataSource
     *      3.工具类设计上不是最优，数据库框架ORM框架Mybatis，都是模板模式设计的
     */
    static {
        ((MysqlDataSource)dataSource).setUrl(URL);
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {

            // 数据库连接失败，抛自定义异常
            throw new AppException("DB001","获取数据库连接失败",throwables);
        }
    }

    public static void close(Connection c, Statement s){
        close(c, s,null);
    }

    public static void close(Connection c, Statement s, ResultSet r){
        try {
            if(r!=null)
                r.close();
            if(s!=null)
                s.close();
            if(c!=null)
                c.close();
        }catch (SQLException e){
            throw new AppException("DB002","数据库释放资源出错",e);
        }
    }
}
