package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/21 23:46
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        //模拟List实现了迭代器
        MyIterator<Integer> it = myList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
