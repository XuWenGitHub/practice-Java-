package cn.itcast_04;

public class Pig extends Animal implements Jump {
    @Override
    public void eat() {
        System.out.println("猪猪饿了，要吃饭");
    }

    @Override
    public void jump() {
        System.out.println("我是一只会跳的猪");
    }
}
