package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/21 21:08
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
//        Node<Integer> node = new Node<>(1);
//        Node<Integer> node2 = new Node<>(1);
//        System.out.println(node.equals(node2));
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(1);
        //myLinkedList.clear();

        //System.out.println(myLinkedList.get(-1));
//        System.out.println(myLinkedList.get(0));
//        System.out.println(myLinkedList.get(3));
//        System.out.println(myLinkedList.get(2));

//        System.out.println(myLinkedList.set(0,-1));
//        System.out.println(myLinkedList.set(3,-4));
//        System.out.println(myLinkedList.set(2,-3));

       // myLinkedList.add(-1,0);
//        myLinkedList.add(0,-1);
//        myLinkedList.add(2,100);
//        myLinkedList.add(myLinkedList.size(),200);


        //System.out.println(myLinkedList.remove(0));
        //System.out.println(myLinkedList.remove(2));
        //System.out.println(myLinkedList.remove(myLinkedList.size()-1));

//        System.out.println(myLinkedList.indexOf(3));
//        System.out.println(myLinkedList.indexOf(1));
//        System.out.println(myLinkedList.indexOf(4));

//        System.out.println(myLinkedList.indexOf(1));
//        System.out.println(myLinkedList.lastIndexOf(1));

       // System.out.println(myLinkedList.remove((Integer)4));


        System.out.println("当前集合元素="+myLinkedList);
        System.out.println("当前集合中元素的个数="+myLinkedList.size());


    }
}
