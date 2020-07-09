package cn.itcast_05;

public class InterImpl<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
