package practice.four;
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
/**
 * @PackgeName: practice.four
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/13 17:30
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
    插入排序
    先自己造一个傀儡节点，然后和head值相同
    然后遍历head的下一个节点，如果和新建的傀儡节点相比，看插入哪里
    要先判断是否插入到第一个位置
    然后判断插入的位置是否有元素，如果有那么要连接起来
    */
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode puppet = new ListNode(head.val);
        ListNode cur = head.next;
        while(cur!=null){
            ListNode curNext = cur.next;
            ListNode puppetCur = puppet;    //遍历傀儡节点
            //看是否插入第一个节点
            if(puppet.val>cur.val){
                puppet = cur;
                cur.next = puppetCur;   //表示插入第一个位置
                cur = curNext;  //后移
                continue;
            }
            while(puppetCur.next!=null&&puppetCur.next.val<=cur.val){
                puppetCur = puppetCur.next;
            }
            if(puppetCur.next==null){
                puppetCur.next = new ListNode(cur.val);
            }else{
                ListNode puppetCurNext = puppetCur.next;
                puppetCur.next = new ListNode(cur.val);
                puppetCur.next.next = puppetCurNext;
            }
            cur = curNext;  //后移
        }
        return puppet;
    }
}
