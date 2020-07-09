package cn.itcast_05;

public class InterImpl2 implements Inter<String> {
    @Override
    public void show(String t) {
        System.out.println(t);
    }
}
