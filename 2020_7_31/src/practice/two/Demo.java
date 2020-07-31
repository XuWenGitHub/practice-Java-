package practice.two;

public class Demo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFrist(1);
        doubleLinkedList.addFrist(-1);
        doubleLinkedList.addFrist(3);
        doubleLinkedList.addFrist(4);
        doubleLinkedList.addFrist(-1);

        doubleLinkedList.addLast(10);
        doubleLinkedList.addLast(-1);
        doubleLinkedList.addLast(12);
        doubleLinkedList.addLast(-1);

//        doubleLinkedList.addIndex(0,-1);
//        doubleLinkedList.addIndex(doubleLinkedList.getLen(),14);
//        doubleLinkedList.addIndex(6,0);
        //System.out.println(doubleLinkedList.contains(123));

//        doubleLinkedList.delete(-1);
//        doubleLinkedList.delete(14);
//        doubleLinkedList.delete(3);
//
//        doubleLinkedList.clear();

        doubleLinkedList.deleteAll(-1);
        doubleLinkedList.list();
    }
}
