package practice.one;

public class LinkedTools {


    //每个单链表里存的1和0，二进制转成10进制
    /*
    分析：
    链表每判断下一个结果，就相当于，把前面的左移1位
    */
    public static int getDecimalValue(ListNode head) {
        int result=0;
        ListNode cur = head;
        while(cur!=null){
            result<<=1;
            result+=cur.val;
            cur=cur.next;
        }
        return result;
    }



    //反转链表
    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode newHead = null;
        ListNode cur = head;    //待反转节点
        ListNode curPrev = null;
        while(cur!=null){
            if(cur.next==null){
                newHead=cur;
            }
            ListNode curNext = cur.next;
            cur.next=curPrev;
            curPrev=cur;
            cur=curNext;
        }
        return newHead;
    }



    /*
    判断一个链表是否是回文结构？
    分析：
    A：先知道一个链表的中间节点，如果1-2-3-4，那么3是中间节点
    B：然后从中间节点的下一个开始，反转，
    C：然后两个引用，一个从头，一个从尾部，往中间跑
    D：如果最后跑跑到同一个节点了，说明是个奇数的回文结构
    E：如果从左往右跑的next是从右往左跑的引用，那说明是个偶数回文结构
    */
    public static boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        if(head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //现在开始反转节点
        ListNode cur = slow.next;   //待反转节点,slow是它的前驱
        while(cur!=null){
            ListNode curNext = cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        //现在开始判断是否是回文结构
        while(head!=slow){
            assert slow != null;
            if(head.val!=slow.val){
                return false;
            }
            if(head.next==slow){
                return true;    //说明是偶数回文结构
            }
            head = head.next;
            slow = slow.next;
        }
        return true;    //说明是基数回文结构
    }



    /*
    实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
    示例：
    输入：单向链表a->b->c->d->e->f中的节点c
    结果：不返回任何数据，但该链表变为a->b->d->e->f
     */
    /*
    分析：我们把d的数据全部赋值给c然后，把c的next指向e
    node节点就是待删除节点
    */
    public static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }



    //判断两个单向链表，是否有交点，如果有交点，返回交点，如果没有交点，返回null
    /*
    分析：
        A：先判断两个链表的长度
        B：再让长度长的先走差值步，
        C：然后两个引用再一起走，如果相等，返回交点，
        D：如果都走到null了，那说明没有交点，返回null
    */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        int lenA=0;
        int lenB=0;
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA!=null){
            lenA++;
            curA=curA.next;
        }
        while(curB!=null){
            lenB++;
            curB=curB.next;
        }
        curA=headA;
        curB=headB;
        if(lenA>lenB){
            for(int i=0;i<lenA-lenB;i++){
                curA=curA.next;
            }
        }else{
            for(int i=0;i<lenB-lenA;i++){
                curB=curB.next;
            }
        }
        while(curA!=null&&curB!=null){
            if(curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }
}
