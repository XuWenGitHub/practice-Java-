package cn.itcast_04;

public class Dog extends Animal{

    @Override//方法重写的意思
    public void eat() {
        System.out.println("狗狗饿了，要吃饭");
    }
}
