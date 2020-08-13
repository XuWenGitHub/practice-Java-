package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/13 12:24
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        /*
        [,"get","addAtHead","addAtIndex","addAtHead"]
        [,,[4],[4],[5,0],[6]]
         */
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.list();
        list.addAtHead(2);
        list.list();
        list.addAtHead(1);
        list.list();
        list.addAtIndex(3,0);
        list.list();
        list.deleteAtIndex(2);
        list.list();
        list.addAtHead(6);
        list.list();
        list.addAtTail(4);
        list.list();
        System.out.println(list.get(4));
        list.list();
        list.addAtHead(4);
        list.list();
        list.addAtIndex(5,0);
        list.list();
        list.addAtHead(6);
        list.list();
    }
}
