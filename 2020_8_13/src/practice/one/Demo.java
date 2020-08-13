package practice.one;

import java.util.ArrayList;

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
 * Date: 2020/8/13 11:11
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        System.out.println(arr.size());
    }
    /*
    链表求和
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        ListNode puppet = new ListNode(-1);
        ListNode puppetCur= puppet;
        int num = 0;    //表示进位
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1!=null&&cur2!=null){
            int value = cur1.val+cur2.val+num;
            puppetCur.next = new ListNode(value%10);
            num = value/10;
            puppetCur = puppetCur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        ListNode cur = cur1==null?cur2:cur1;
        if(cur==null){
            if(num!=0){
                puppetCur.next = new ListNode(num);
                puppetCur = puppetCur.next;
            }
        }else{
            if(num==0){
                puppetCur.next = cur;
                puppetCur = puppetCur.next;
            }else{
                //把num全部弄给后面的cur，直到num==0或者temp变空
                ListNode temp = cur;
                while(temp!=null&&num!=0){
                    int value = temp.val+num;
                    temp.val = value%10;
                    num = value/10;
                    temp = temp.next;
                }
                if(num==0){
                    puppetCur.next = cur;
                    //puppetCur = puppetCur.next;
                }else{
                    puppetCur.next = cur;
                    while(cur.next!=null){
                        cur = cur.next;
                    }
                    cur.next = new ListNode(num);
                }

            }
        }
        return puppet.next;
    }
}
