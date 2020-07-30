package practice.one;

import practice.two.LinkedTools;

public class Demo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFrist(0);
        myLinkedList.addFrist(2);
        myLinkedList.addFrist(123);
        myLinkedList.addFrist(2);
        myLinkedList.addFrist(0);


        myLinkedList.list();
        //myLinkedList.setHead(myLinkedList.partition(30));
        //System.out.println(myLinkedList.chkPalindrome());
        //myLinkedList.list();

        System.out.println(LinkedTools.isPalindrome(myLinkedList.getHead()));
    }
}
