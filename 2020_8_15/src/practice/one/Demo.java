package practice.one;
class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val = val;
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/15 10:10
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
        Node head =new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        head.next = node1;
        node1.next= node2;
        node2.next = node3;
        node3.next = node4;
        list(head);
        head= reversePart(head,3,5);
        list(head);
    }

    /**
     * 1->2->3->4->5
     * 链表部分逆序，最重要的地方,例如逆序1-3
     * 2,3往前指向,最后1要指向3的后面这个，
     * 1的prev要指向3，如果1的prev为null，那就把3置为head即可
     * 找到：start有效节点，startPrev节点,end节点,end节点的next
     * @param head  待逆序的链表头结点
     * @param start 从第几个开始逆序(1开始
     * @param end   从第几个结束逆序
     */
    public static Node reversePart(Node head,int start,int end){
        if(end==start||head==null||head.next==null){
            return head;
        }
        Node startNode = head;
        Node startPrevNode = null;  //最后要判断其为不为空
        Node endNode = null;
        Node endNextNode = null;

        //让startNode指向start位置的节点，让startPrev也是start的前置
        for(int i=1;i<start;i++){
            startPrevNode = startNode;
            startNode = startNode.next;
        }

        //现在定义cur = startNode.next;让从start+1位置开始往前指
        Node cur = startNode.next;  //开始往前指
        Node curPrev = startNode;   //前驱
        for(int i=0;i<end-start;i++) {
            Node curNext = cur.next;    //提前保存好后继
            cur.next= curPrev;
            curPrev = cur;
            cur = curNext;
        }

        //退出循环后，curPrev在end位置的节点，cur在end位置的节点的后一个
        endNode = curPrev;
        endNextNode = cur;

        startNode.next = endNextNode;   //让start指向end后面那个
        //判断是不是第一个节点，如果是，为null，就把end置为head
        //如果不是null，就让startPrev -> endNode
        if(startPrevNode==null){
            head = endNode;
        }else{
            startPrevNode.next = endNode;
        }

        return head;
    }
}
