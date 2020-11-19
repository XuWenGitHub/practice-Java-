package org.example;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDataSource {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Emp> list = new ArrayList<>();
        try {
            //第一步：加载JDBC驱动程序：反射，这样调用初始化com.mysql.jdbc.Driver类，即将该类加载到JVM方法区，并执行该类的静态方法块、静态属性。
            //创建数据库连接池,复用资源，提高效率，不然每次一次sql语句都要去创建对象，耗费时间资源
            //MysqlDataSource里面会自己加载驱动
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource)ds).setUrl("jdbc:mysql://localhost:3306/test?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            connection = ds.getConnection();
            System.out.println(connection);

            //第二步：创建操作命令对象Statement
//            statement = connection.createStatement(); //创建简单的操作命令对象

            //第三步：执行sql
            //sql语句中？代表占位符，然后数据库编译的时候，就把？替换成connection.prepareStatement(sql,?)中的？
            String sql = "select id,name,role,salary from emp";
            //prepareStatement预编译的操作命令对象，注意使用String sql传入参数
            statement = connection.prepareStatement(sql);
            //如果有sql中有？，那么就需要替换占位符
            //statement.setXxx(1,xxx)   1代表占位符的位置（从1开始）

            //拿到结果集
            resultSet = statement.executeQuery();

            //第四步：处理结果集（查询操作)
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                System.out.println(String.format("id=%s,name=%s,role=%s,salary=%s",
                        id, name, role, salary));

                Emp emp = new Emp(id,name,role,salary);
                list.add(emp);
            }


        } catch ( SQLException e) {
            e.printStackTrace();
        } finally {
            //第五步：释放资源
            try {
                //关闭结果集
                if(resultSet!=null)
                    resultSet.close();
                //关闭命令
                if(statement!=null)
                    statement.close();
                //重置连接
                if(connection!=null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    static class Emp{
        Integer id;
        String name;
        String role;
        BigDecimal salary;

        public Emp(Integer id, String name, String role, BigDecimal salary) {
            this.id = id;
            this.name = name;
            this.role = role;
            this.salary = salary;
        }

        public Emp() {
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
