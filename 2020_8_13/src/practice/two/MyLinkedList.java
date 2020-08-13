package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: MyLinkedList
 * @Author: XuWen
 * Date: 2020/8/13 12:24
 * Introduce:
 */
class MyLinkedList {
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    private Node head;  //第一个有效节点,不带头节点的单链表

    public boolean isEmpty(){
        return head==null;
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(isEmpty()||index<0){
            return -1;
        }
        Node puppet = new Node(-1); //傀儡节点
        puppet.next = head;
        Node cur = puppet;
        for(int i=0;i<=index;i++){
            cur = cur.next;
            if(cur==null){
                return -1;  //表示index不合法
            }
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(isEmpty()){
            head = new Node(val);
            return;
        }
        Node headNext = head;
        head = new Node(val);
        head.next = headNext;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(isEmpty()){
            head = new Node(val);
            return;
        }
        Node cur = head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = new Node(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int length = length();
        if(index==length){
            addAtTail(val);
            return;
        }
        if(index>length){
            return;
        }
        if(index<0||index==0){
            addAtHead(val);
            return;
        }
        Node cur = head;
        for(int i=1;i<index;i++){
            cur = cur.next;
        }
        Node curNext = cur.next;
        cur.next = new Node(val);
        cur.next.next = curNext;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(isEmpty()||index>length()-1||index<0){
            return;
        }
        if(index==0){
            head = head.next;
            return;
        }
        Node cur = head;
        for(int i=1;i<index;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
    public int length(){
        if(isEmpty()){
            return 0;
        }
        Node cur = head;
        int count = 0;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void list(){
        if(isEmpty()){
            System.out.println("链表为空");
            return;
        }
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
