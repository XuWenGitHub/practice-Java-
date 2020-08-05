package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: SystemUtil
 * @Author: XuWen
 * Date: 2020/8/5 22:15
 * Introduce:
 */
public class SystemUtil{
    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main(String[] args){
        System.out.println(isAdmin("Admin"));
    }

}
