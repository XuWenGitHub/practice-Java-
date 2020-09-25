package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: SingleCase
 * @Author: XuWen
 * Date: 2020/9/24 18:20
 * Introduce:
 */
public class SingleCase {
    private SingleCase(){
        System.out.println("这是单例模式");
    }
    private static class Inner{
        private static SingleCase s = new SingleCase();
    }
    public static SingleCase getSingleCase(){
        return Inner.s;
    }
}
