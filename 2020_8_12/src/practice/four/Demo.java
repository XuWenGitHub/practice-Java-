package practice.four;

import java.util.List;

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
 * Date: 2020/8/12 15:13
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
    输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 8 -> 0 -> 7
    分析；先反转两个链表，得到反转的链表后
    然后一个一个加
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        //先反转两个链表,建立一个新的链表
        ListNode node1 = reverse(l1);
        ListNode node2 = reverse(l2);
        ListNode puppet = new ListNode(-1);
        ListNode puppetCur = puppet;
        int digit = 0;  //如果两者加的超过10.就要进位
        while(node1!=null&&node2!=null){
            int value = (node1.val+node2.val+digit)%10; //取出个位
            digit = (node1.val+node2.val+digit)/10; //取出十位
            puppetCur.next = new ListNode(value);
            puppetCur = puppetCur.next;
            node1=node1.next;
            node2 = node2.next;
        }
        //当循环退出，如果两者谁有剩余，直接连接起来,但是这里要判断digit是否为0
        ListNode cur = node1==null?node2:node1; //就是剩余的,也可能为null
        if(cur==null){
            //表示两个链表都为null了
            if(digit!=0){
                puppetCur.next = new ListNode(digit);
            }
        }else{
            //表示有一个没有为null,现在又判断digit是否为0
            if(digit==0){
                puppetCur.next = cur;
            }else{
                while(digit!=0&&cur!=null){
                    int value = digit+cur.val;
                    puppetCur.next = new ListNode(value%10);
                    cur = cur.next;
                    puppetCur = puppetCur.next;
                    digit = value/10;
                }
                if(digit==0){
                    puppetCur.next = cur;
                }else{
                    puppetCur.next = new ListNode(digit);
                }
            }
        }
        return reverse(puppet.next);
    }
    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode curPrev = null;
        ListNode puppet = null;
        while(cur!=null){
            if(cur.next==null){
                puppet = cur;
            }
            ListNode curNext = cur.next;
            cur.next = curPrev;
            curPrev = cur;
            cur = curNext;
        }
        return puppet;
    }
}
