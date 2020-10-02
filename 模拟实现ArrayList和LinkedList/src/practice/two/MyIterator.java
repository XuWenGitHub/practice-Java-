package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: MyIterator
 * @Author: XuWen
 * Date: 2020/9/21 23:31
 * Introduce:
 */
public interface MyIterator<T> {
    boolean hasNext();
    T next();
    void remove();
}
