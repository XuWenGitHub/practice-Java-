package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/18 17:59
 * Introduce:
 */
public class Demo {
    public static void list(Node head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println("逆序前：");
        list(head);
        System.out.println("头插法逆序链表后:");
        list(reverse(head));
    }
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    //返回逆置后的链表
    public static Node reverse(Node head){
        Node puppet = new Node(-1); //傀儡节点,也是傀儡链表
        Node cur = head;    //遍历传进来的链表
        while(cur!=null){
            Node puppetNext = puppet.next;  //保存傀儡链表的第二个
            Node curNext = cur.next;    //保存cur的下一个节点，防止防止丢失链表
            puppet.next = cur;
            cur.next = puppetNext;
            cur = curNext;
        }
        return puppet.next;
    }
}
