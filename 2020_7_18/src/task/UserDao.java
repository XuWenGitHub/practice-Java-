package task;

public interface UserDao {
    /**
     * 这是用户登录工能
     * @param username  用户名
     * @param password  密码
     * @return  是否登录成功
     */
    public abstract boolean isLogin(String username,String password);

    /**
     * 这是用户注册功能
     * @param user  需注册的用户信息
     */
    public abstract void regist(User user);
}
