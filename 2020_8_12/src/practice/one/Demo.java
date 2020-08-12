package practice.one;
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/12 10:15
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
   分析：
   A：定义一个傀儡节点，然后连接head
   B：然后定义三个指针，一个cur，一个curPrev,一个curNext
   C：直到cur或者cur.next为null
   */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode puppet = new ListNode(-1);
        ListNode puppetCur = puppet;
        ListNode cur = head;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                puppetCur.next = cur;
                puppetCur = cur;
                cur = cur.next;
            }
        }
        puppetCur.next = null;
        return puppet.next;
    }
}
