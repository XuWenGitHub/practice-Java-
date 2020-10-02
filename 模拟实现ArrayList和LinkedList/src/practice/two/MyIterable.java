package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: MyIterable
 * @Author: XuWen
 * Date: 2020/9/21 23:30
 * Introduce:
 */
public interface MyIterable<T> {
    MyIterator<T> iterator();
}
