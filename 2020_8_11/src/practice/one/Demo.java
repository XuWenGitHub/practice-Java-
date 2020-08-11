package practice.one;
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
class Node{
    public int val;
    public Node next;
    public Node random;
    public Node(int val){
        this.val=val;
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/11 10:23
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
    分析：
    A：先把每一个节点深拷贝到每个节点的后面。
    B：然后给每个拷贝的节点random赋值，就是被拷贝的节点random.next就是拷贝节点的random
    C：分割链表
    */
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        //每个节点后面，深拷贝个val相同的节点，连接起来
        Node cur = head;
        while(cur!=null){
            Node newCur = new Node(cur.val);
            Node curNext = cur.next;
            cur.next = newCur;
            newCur.next = curNext;
            cur = cur.next.next;
        }
        //给新节点random赋值
        cur = head;
        while(cur!=null){
            Node curNext = cur.next;
            if(cur.random!=null){
                curNext.random = cur.random.next;
            }
            cur=cur.next.next;
        }
        //分割两个链表
        Node newNode = new Node(-1);
        Node newNodeCur = newNode;
        cur = head;
        while(cur!=null){
            Node curNext = cur.next;
            newNodeCur.next = curNext;
            newNodeCur = curNext;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        newNodeCur.next = null;
        return newNode.next;
    }





    /*
    给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
    输入：head = [1,2,-3,3,1]
输出：[3,1]
提示：答案 [1,2,1] 也是正确的。
    分析：
    A：先弄一个傀儡节点,连接head
    B：然后cur从head开始，curPrev就是该傀儡节点，
    C：然后先判断cur的值是不是0，如果是就删除当前cur，然后cur后移，curPrev不动,continue
    D：然后不是0，然后sum+=该值，然后定义一个curNext，然后往后跑，直到sum==0，如果最后不等于，就让cur后移，curPrev变成cur，如果sum==0，让curPrev.next = curNext.next;
    然后cur = curNext.next,然后进入下次循环
    */
    public static ListNode removeZeroSumSublists(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head.val==0?null:head;
        }
        ListNode newNode = new ListNode(-1);    //傀儡节点
        newNode.next = head;
        ListNode cur = head;    //判断当前节点值和后面的是否可以变成0
        ListNode curPrev = newNode; //前驱
        boolean flag = true;
        while(cur!=null){
            flag = true;
            int sum=cur.val;
            if(sum==0){
                curPrev.next = cur.next;
                cur=cur.next;
                continue;
            }
            ListNode curNext = cur.next;
            while(curNext!=null){
                sum+=curNext.val;
                if(sum==0){
                    curPrev.next = curNext.next;
                    cur=curNext.next;
                    flag=false;
                    break;
                }
                curNext = curNext.next;
            }
            if(flag){
                curPrev = cur;
                cur = cur.next;
            }
        }
        return newNode.next;
    }
}
