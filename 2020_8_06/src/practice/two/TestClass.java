package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: TestClass
 * @Author: XuWen
 * Date: 2020/8/7 1:09
 * Introduce:
 */
public class TestClass {

    private static void testMethod(){

        System.out.println("testMethod");

    }

    public static void main(String[] args) {

        ((TestClass)null).testMethod();

    }

}
