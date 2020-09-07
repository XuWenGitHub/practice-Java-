import java.sql.*;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/31 14:48
 * Introduce:
 */
public class Demo {
    //初始化数据库
    private final static String url = "jdbc:mysql://localhost:3306/shop?useSSL=false";
    private final static String user = "root";
    private final static String password= "123456";

    //查看这些类提供的方法
    private static Connection coon=null;
    private static PreparedStatement pst = null;    //用于添加数据
    private static ResultSet rs = null;


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");      //5.1驱动导入
            coon = DriverManager.getConnection(url,user,password);  //连接数据库
            System.out.println("连接成功");
            String sql = "select * from petshop;";
            pst = coon.prepareStatement(sql);
            rs = pst.executeQuery();
            String name=null;   //狗姓名
            String owner = null;    //狗主人
            String species= null;   //狗种类
            String sex = null;  //狗性别
            String birth = null;    //狗生日
            String death= null; //狗死亡日期

            while(rs.next()){
                name = rs.getString("name");
                owner = rs.getString("owner");
                species = rs.getString("species");
                sex = rs.getString("sex");
                birth = rs.getString("birth");
                death = rs.getString("death");
                System.out.println(name+" "+owner+" "+species+" "+sex+" "+birth+" "+death+" ");
            }
            String insert = "insert into petshop values ('b','s','d','f','1999-03-30',NULL);";

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
