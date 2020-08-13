package practice.three;
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/13 12:55
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
    分析：删除链表的倒数第n个节点，并且返回链表的头结点
    A：定义快慢两个指针，快指针先走n步，如果走到null了
    B：先找到倒数第n+1个节点，就是待删除节点的前一个，找到了后，然后删除下一个即可
    C：如果快指针往前走的时候，走到了空，要判断。如果i==n，说明删除的是第一个有效节点
    D：如果i！=n那说明，n大于链表的长度了
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<1||head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<n+1;i++){
            if(fast==null){
                if(i==n){
                    //表示删除第一个有效节点
                    head = head.next;
                    return head;
                }
                return null;    //表示n大于链表长度了
            }
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
