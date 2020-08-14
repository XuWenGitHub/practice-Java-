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
 * Date: 2020/8/14 11:27
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
    两两交换其中相邻的节点
    给定 1->2->3->4, 你应该返回 2->1->4->3.
    */
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        ListNode temp = null;   //存cur2的下一个位置，就是cur1下次移动到的地方
        while(cur1!=null&&cur2!=null){
            ListNode cur2Next = cur2.next;
            if(temp==null){
                //表示第一次，就要更改head
                temp = cur1;
                cur2.next = cur1;
                cur1.next = cur2Next;
                head = cur2;
                //下面移动cur1和cur2
                cur1 = cur2Next;
                if(cur1==null){
                    break;
                }
                cur2 = cur1.next;
            }else{
                //表示不是第一次，就不需要更改head
                cur2.next = cur1;
                cur1.next = cur2Next;
                temp.next = cur2;
                temp = cur1;
                //下面移动cur1和cur2
                cur1 = cur2Next;
                if(cur1==null){
                    break;
                }
                cur2 =cur1.next;
            }
        }
        return head;
    }
}
