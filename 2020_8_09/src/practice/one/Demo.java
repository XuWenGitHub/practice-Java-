package practice.one;
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/9 12:01
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
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next=node3;
        node3.next = node4;
        node4.next=node5;
        list(head);
        ListNode headnewNode = oddEvenList(head);
        list(headnewNode);
    }
    /*
   分析：
   给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节     点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
   输入: 1->2->3->4->5->NULL
   输出: 1->3->5->2->4->NULL
   A：做两个傀儡节点
   B：遍历链表，第一个肯定是偶数，第二个肯定是基数，用flag来表示基数还是偶数
   C：偶数存在even链表，奇数存在odd链表
   */
    public static ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode odd = new ListNode(-1);    //存奇数
        ListNode oddCur = odd;   //表示奇数链表的最后一个
        ListNode even = new ListNode(-1);   //存偶数
        ListNode evenCur = even; //表示偶数链表的最后一个
        boolean flag = true;    //true表示偶数，false表示奇数
        ListNode cur = head;
        while(cur!=null){
            if(flag){
                //表示偶数
                evenCur.next = cur;
                evenCur = cur;
                flag=false;
            }else{
                //表示奇数
                oddCur.next = cur;
                oddCur = cur;
                flag=true;
            }
            cur = cur.next;
        }
        //退出后
        if(even.next==null){
            return odd.next;
        }
        evenCur.next = odd.next;
        oddCur.next = null;
        return even.next;
    }
}
