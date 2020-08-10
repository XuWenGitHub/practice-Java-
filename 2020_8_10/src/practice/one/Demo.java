package practice.one;
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/10 14:43
 * Introduce:
 */
class Node{
    public int val;
    public Node next;
    public Node random;
    public Node(int val){
        this.val = val;
    }
}
public class Demo {
    public static void main(String[] args) {
        int[] arr ={1,2,3};

    }





    /*
   给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的 深拷贝。 
我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

   第一步，根据遍历到的原节点创建对应的新节点，每个新创建的节点是在原节点后面
   第二步，原节点1的随机指针指向原节点3，新节点1的随机指针指向的是原节点3的next
原节点3的随机指针指向原节点2，新节点3的随机指针指向的是原节点2的next
   第三步，将两个链表分离，然后返回新的链表即可
   */
    public static Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur = head;
        //给链表每一个节点的后面复制一个新的节点
        while(cur!=null){
            Node curCopy = new Node(cur.val);   //复制了当前节点
            //将新节点添加到当前节点后面
            Node curNext = cur.next;
            cur.next=curCopy;
            curCopy.next=curNext;
            //cur后移
            cur = cur.next.next;
        }
        //给新的节点赋random值
        cur = head;
        while(cur!=null){
            Node curNext = cur.next;
            if(cur.random!=null){
                curNext.random=cur.random.next;
            }
            cur = cur.next.next;
        }
        //链表分离,分离时要保证，恢复原来链表的样子
        Node newNode = new Node(-1);
        Node newNodeCur = newNode;
        cur = head;
        while(cur!=null){
            Node curNext = cur.next;
            cur.next = cur.next.next;

            newNodeCur.next = curNext;
            newNodeCur = curNext;

            cur = cur.next;
        }
        newNodeCur.next = null;
        return newNode.next;
    }


    /*
    要分割链表，比x小的在前面，比x大于等于的再后面，但是不能改变其原始顺序
    分析：
    A：定义两个傀儡链表，一个来存比x小的，一个来存储比x大于等于的，最后一拼接即可
    但是要注意，拼接时候要判空
    */
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);  //存放比x小的
        ListNode big = new ListNode(-1);    //存放大于等于x的
        ListNode smallCur = small;
        ListNode bigCur = big;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val<x){
                smallCur.next = cur;
                smallCur = cur;
            }else{
                bigCur.next = cur;
                bigCur = cur;
            }
            cur = cur.next;
        }
        if(small.next==null){
            return big.next;
        }
        smallCur.next= big.next;
        bigCur.next= null;
        return small.next;
    }

    /*
    找到有环链表的返回环路的开头节点
    分析：
    A：先定义两个节点，然后一个每次走一步，一个每次走两步，直到两者相遇，表示有环
    B：如果相遇后，一个从head开始，一个从当前开始，一人一步走，再次相遇，就返回
    */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;    //表示没有环
        }
        slow = head;
        while(slow!=fast){
            slow=slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
