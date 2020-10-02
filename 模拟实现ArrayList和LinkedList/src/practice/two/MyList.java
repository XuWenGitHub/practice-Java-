package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: MyList
 * @Author: XuWen
 * Date: 2020/9/21 23:37
 * Introduce:
 */
public interface MyList<T> extends MyIterable<T> {
    void add(T e);
}
