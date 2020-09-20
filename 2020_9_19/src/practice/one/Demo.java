package practice.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    public Integer val;
    public Node prev;
    public Node next;

    public Node(Integer val) {
        this.val = val;
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/19 19:35
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(1);
        System.out.println(node.val.equals(node1.val));
        final var lists = yangHui(10);
        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);
        System.out.println(queue.element());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.remove());
        System.out.println(queue);
    }

    /**
     * 打印杨辉三角，存入list集合里面
     * @param n 代表行
     * @return  杨辉三角
     */
    public static List<List<Integer>> yangHui(int n){
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<n;i++){   //遍历每一行
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    list.add(1);
                }
                if(i>1&&j!=0&&j!=i){
                    list.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
                }
            }
            lists.add(list);
        }
        return lists;
    }

//    public void add(int index,Integer e){
//        if(index<0||index>size){
//            throw new IndexOutOfBoundsException("下标越界："+index);
//        }
//        //从链表头部添加
//        if(index==0){
//            this.addFrist(e);
//            return;
//        }
//        //从链表尾部添加
//        if(index==size){
//            this.addLast(e);
//            return;
//        }
//        Node newNode = new Node(e);
//        //在链表中间添加
//        Node cur = head;
//        for(int i=0;i<index;i++){
//            cur = cur.next;
//        }
//        //遍历结束后，cur指向待插入位置当前的节点
//        cur.prev.next = newNode;    //待插入位置的节点的上一个节点的next指向新的节点
//        newNode.prev = cur.prev;
//        newNode.next = cur;
//        cur.prev = newNode;
//
//        this.size++;
//    }
}
