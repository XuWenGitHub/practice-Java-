package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: SinglePattern
 * @Author: XuWen
 * Date: 2020/10/12 23:03
 * Introduce:
 */
public class SinglePattern {
    private SinglePattern(){}
    private static class Inner{
        private static SinglePattern singlePattern = new SinglePattern();
    }
    public static SinglePattern getSingle(){
        return Inner.singlePattern;
    }
}
