package practice.two;

import java.util.ArrayList;
import java.util.List;
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/12 10:46
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {


    }
    /*
    分析：
    A：定义两条链表，一条存小于3的，一条存大于等于3的
    B：最后拼接起来即可
    */
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode small = new ListNode(-1);
        ListNode smallCur = small;
        ListNode big = new ListNode(-1);
        ListNode bigCur = big;
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
        smallCur.next = big.next;
        bigCur.next = null;
        return small.next;
    }
}
