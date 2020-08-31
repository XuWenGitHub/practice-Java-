package cn.itcast_02;

public class StudentImpl implements StudentDao{
    @Override
    public void login() {
        System.out.println("登录功能");
    }

    @Override
    public void regist() {
        System.out.println("注册功能");
    }
}
