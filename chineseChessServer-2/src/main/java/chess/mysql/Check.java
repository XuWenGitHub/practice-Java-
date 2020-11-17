package chess.mysql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 连接服务器，进行账户名和密码校验
 */
public class Check {
    private String username;
    private String password;

    //数据库连接池
    public static DataSource ds;
    //数据库连接对象
    Connection connection = null;
    //操作命令对象
    PreparedStatement statement = null;
    //结果集
    ResultSet resultSet = null;

    //静态代码块，只调用一次,和数据库建立连接
    static {
        ds = new MysqlDataSource();
        ((MysqlDataSource) ds).setUrl("jdbc:mysql://localhost:3306/chinesechess?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
    }

    public Check(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean check() {
        try {
            connection = ds.getConnection();
            String sql = "select username,password from login where username=? and password=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            resultSet = statement.executeQuery();

            //代表找到的结果，如果为1表示正确，如果为0表示登录失败，如果都不是那就是bug
            //因为用户名不能重复且都不能为空
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            if (count == 0) {
                return false;
            } else if (count == 1) {
                return true;
            } else {
                throw new RuntimeException("bug，找到了账号和密码全部相同的数据多条");
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();   //连接异常
            throw new RuntimeException("连接错误", throwables);
        } finally {

            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if(connection!=null)
                    connection.close(); //这里不是断开服务器的连接，这里是重置连接，等待下一个连接的来用
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                //throw new RuntimeException("释放资源异常");
            }

        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
