package practice.two;

import java.util.*;

/**
 * @PackgeName: practice.two
 * @ClassName: MyArrayList
 * @Author: XuWen
 * Date: 2020/9/21 23:28
 * Introduce:
 */
public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size;

    @Override
    public MyIterator<T> iterator() {
       return new ArrayListIterator<T>(arr,size);
    }

    @Override
    public void add(T e) {
        if(arr==null){
            arr = (T[])new Object[10];
        }
        arr[size] = e;
        size++;
    }
}
