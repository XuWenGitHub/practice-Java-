package practice.one;

import java.util.HashSet;
import java.util.Set;

public class LinkedTools {

    /*
    链表中倒数第k个节点
    */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(k<1){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<k;i++){
            if(fast==null){
                return null;
            }
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }



    /*
    删除val值的节点
    定义一个傀儡节点
    每次判断和val相等吗，如果相等，不添加，不相等添加
    */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode newNode = new ListNode(-1);
        ListNode newNodeCur = newNode;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val==val){
                cur=cur.next;
            }else{
                newNodeCur.next=cur;
                newNodeCur=cur;
                cur=cur.next;
            }
        }
        newNodeCur.next=null;
        return newNode.next;
    }




    /*
    移除未排序链表中的重复节点
    分析：
    A：用HashSet来存储每个节点，
    B：如果hashSet里面没有，就存进去，如果有，删除该节点
    */
    public static ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> hash = new HashSet<>();
        ListNode newNode = new ListNode(-1);    //傀儡节点
        ListNode curNewNode = newNode;
        ListNode cur = head;    //遍历的节点
        ListNode curPrev = newNode; //该节点的前驱节点
        while(cur!=null){
            if(!hash.contains(cur.val)){
                hash.add(cur.val);
                curNewNode.next=cur;
                curNewNode=curNewNode.next;
                curPrev=cur;
                cur=cur.next;
            }else{
                cur=cur.next;
            }
        }
        curNewNode.next=null;
        return newNode.next;
    }




    /*
    求两个链表的交点
    A：先求出两个链表的长度
    B：curA和curB分别遍历两个链表
    C：长度长的，先走差值步，然后一步步走，相遇了，就返回交点
    */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while(curA!=null){
            lenA++;
            curA=curA.next;
        }
        while(curB!=null){
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if(lenA>lenB){
            for(int i=0;i<lenA-lenB;i++){
                curA=curA.next;
            }
        }else{
            for(int i=0;i<lenB-lenA;i++){
                curB = curB.next;
            }
        }
        while(curA!=null&&curB!=null){
            if(curA==curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
