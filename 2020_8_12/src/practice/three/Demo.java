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
 * Date: 2020/8/12 11:00
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
   分析：反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
   第一步：找到待反转节点的前一个节点。
   第二步：反转m到n这部分。
   第三步：将反转的起点的next指向反转的后面一部分。
   第四步：将第一步找到的节点指向反转以后的头节点。
   */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode puppet = new ListNode(-1);
        puppet.next = head;
        ListNode node = puppet;
        //让node指向第一个待反转节点的前一个,1
        for(int i=1;i<m;i++){
            node = node.next;
        }
        //反转m到n这部分。
        ListNode cur = node.next.next;   //待反转节点,3
        ListNode curPrev = node.next;    //2
        for(int i=m;i<n;i++){
            ListNode curNext = cur.next;
            cur.next = curPrev;
            curPrev = cur;
            cur = curNext;
        }
        //将反转的起点的next指向反转的后面一部分。
        //将第一步找到的节点指向反转以后的头节点。
        node.next.next=cur;
        node.next=curPrev;
        return puppet.next;
    }
}
