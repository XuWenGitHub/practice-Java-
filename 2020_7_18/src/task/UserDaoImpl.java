package task;

import java.util.ArrayList;

/**
 * 这是用户操作的具体实现类
 */
public class UserDaoImpl implements UserDao{
    private static ArrayList<User> arrayList = new ArrayList<>();

    @Override
    //登录
    public boolean isLogin(String username, String password) {
        boolean flag=false;
        for(User user:arrayList){
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                flag=true;
                break;
            }
        }
        return flag;
    }

    @Override
    //注册
    public void regist(User user) {
        arrayList.add(user);
    }
}
