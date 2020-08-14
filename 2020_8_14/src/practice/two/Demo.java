package practice.two;
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/14 17:48
 * Introduce:
 */
public class Demo {
    public static void list(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        list(head);
        head = reversePart2(head,1,2);
        list(head);
    }
    /*
    如果k小于等于链表长度，就开始反转
    给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

    示例 1:
    输入: 1->2->3->4->5->NULL, k = 2
    输出: 4->5->1->2->3->NULL
    解释:
    向右旋转 1 步: 5->1->2->3->4->NULL
    向右旋转 2 步: 4->5->1->2->3->NULL
    */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
            return head;
        }
        int len = length(head); //链表的长度
        int after = 0;
        if(k<=len){
            after = len-k;
            head = reversePart(head,1,after);
            head = reversePart(head,after+1,len);
            head = reversePart(head,1,len);
        }else{
            after = k%len;
            after = len-after;
            head = reversePart(head,1,after);
            head = reversePart(head,after+1,len);
            head = reversePart(head,1,len);
        }
        return head;
    }
    //写一个方法，可以反转从第start个有效节点到第after个有效节点反转
    /*
    先要找一个指针来保存start位置的节点
    再在一个指针来保存start上一个节点,如果startPrevNode为null，说明head=cur
    */
    public ListNode reversePart(ListNode head,int start,int after){
        if(start==after){
            return head;
        }
        ListNode startNode = head;  //保存start位置的节点
        ListNode startPrevNode = null;  //保存start位置前面一个节点,如果它为null，说明start是head，那么便把after位置的节点变成head

        //让startNode移动到第一个待反转的节点,startPrevNode是第一个待反转节点的前一个节点
        for(int i=1;i<start;i++){
            startPrevNode = startNode;      //3
            startNode = startNode.next;  //4
        }
        ListNode curPrev = null;   //cur的前驱
        ListNode cur = startNode;    //start位置节点的下一个节点,待逆转的节点
        if(cur==null){
            return head;
        }
        ListNode curNext = startNode.next;
        for(int i=0;i<after-start;i++){
            curPrev = cur;
            cur=curNext;
            curNext = curNext.next;
            cur.next = curPrev;
        }
        //退出循环后，cur指向after位置的节点，curPrev指向after位置节点的前一个节点
        startNode.next = curNext;  //其实反转节点连接after后面那个
        if(startPrevNode==null){
            head = cur; //如果其实节点是head，那么便把cur节点置为head
        }else{
            startPrevNode.next = cur;   //起始节点的prev连接after节点
        }
        return head;
    }

    //再写一个方法，求链表的长度
    public int length(ListNode head){
        int len=0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
    //写一个方法，可以反转从第start个有效节点到第after个有效节点反转
    /*
    先要找一个指针来保存start位置的节点
    再在一个指针来保存start上一个节点,如果startPrevNode为null，说明head=cur
    */
    public static ListNode reversePart2(ListNode head,int start,int after){
        if(start==after){
            return head;
        }
        ListNode startNode = head;  //保存start位置的节点
        ListNode startPrevNode = null;  //保存start位置前面一个节点,如果它为null，说明start是head，那么便把after位置的节点变成head

        //让startNode移动到第一个待反转的节点,startPrevNode是第一个待反转节点的前一个节点
        for(int i=1;i<start;i++){
            startPrevNode = startNode;
            startNode = startNode.next;
        }

        ListNode curPrev = null;   //cur的前驱
        ListNode cur = startNode;    //start位置节点,待逆转的节点
        if(cur==null){
            return head;
        }
        ListNode curNext = startNode.next;  //cur的next域
        for(int i=0;i<after-start;i++){
            curPrev = cur;
            cur=curNext;
            curNext = curNext.next;
            cur.next = curPrev;
        }
        //退出循环后，cur指向after位置的节点，curPrev指向after位置节点的前一个节点
        startNode.next = curNext;  //其实反转节点连接after后面那个
        if(startPrevNode==null){
            head = cur; //如果其实节点是head，那么便把cur节点置为head
        }else{
            startPrevNode.next = cur;   //起始节点的prev连接after节点
        }
        return head;
    }
}
