package practice.one;

public class Demo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addSort(4);
        myLinkedList.addSort(2);
        myLinkedList.addSort(3);
        myLinkedList.addSort(2);
        myLinkedList.addSort(-1);
        myLinkedList.addSort(0);
//        myLinkedList.addFrist(-1);
//        myLinkedList.addLast(4);
//
//        myLinkedList.clear();
//        myLinkedList.addIndex(0,100);
//        myLinkedList.addLast(10);
//        myLinkedList.addFrist(-1);
//        myLinkedList.addFrist(1);
//        myLinkedList.addLast(-100);
//
//        myLinkedList.deleteAllKey(4);
        myLinkedList.deleteAllKey(-1);

        myLinkedList.list();

    }
}
