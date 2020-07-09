package cn.itcast_05;

public class InterDemo {
    public static void main(String[] args) {
        Inter i = new InterImpl();
        i.show("徐文");
        i.show(20);
        i.show(true);

        Inter i2 = new InterImpl2();
        i2.show("true");
    }
}
