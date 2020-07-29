package practice.one;

import java.util.Stack;
import java.util.zip.InflaterInputStream;

public class Demo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);

        myLinkedList.list();
        //myLinkedList.setHead(myLinkedList.reverse());
        //myLinkedList.reverse2();
        int k=2;
        System.out.println("倒数第"+k+"个数据是"+myLinkedList.findLastK(k).getData());
        //System.out.println(myLinkedList.findMid().getData());
        myLinkedList.list();

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.size());
        int a=stack.pop();
        System.out.println(stack.size());
    }

}
