package practice.two;

import java.util.Iterator;

/**
 * @PackgeName: practice.two
 * @ClassName: ArrayListIterator
 * @Author: XuWen
 * Date: 2020/9/21 23:38
 * Introduce:
 */
public class ArrayListIterator<T> implements MyIterator<T> {
    public T[] arr;
    public int size;
    public int index=0;

    public ArrayListIterator(T[] arr, int size) {
        this.arr = arr;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return index<size;
    }

    @Override
    public T next() {
        return arr[index++];
    }

    @Override
    public void remove() {

    }
}
