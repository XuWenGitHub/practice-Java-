package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: TestClass
 * @Author: XuWen
 * Date: 2020/8/19 15:02
 * Introduce:
 */
class UseFul {
    public void f(){
        System.out.println("UseFul f");
    }public void g(){
        System.out.println("UseFul g");
    }
}
public class TestClass extends UseFul {
    public void f() {
        System.out.println("TestClass f");
    }
    public void g() {
        System.out.println("TestClass g");
    }
    public void h() {
        System.out.println("TestClass h");
    }
    public void i() {
        System.out.println("TestClass i");
    }
    public static void main(String[] args) {
        UseFul[] useFuls = {new UseFul(),new TestClass()};
        useFuls[1].f();
        useFuls[1].g();
        new TestClass().h();
        new TestClass().i();
    }
}
