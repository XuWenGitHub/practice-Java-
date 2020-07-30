package practice.two;

import practice.one.Node;

public class LinkedTools {
    /*
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
    说明：不允许修改给定的链表。
    */
    /*
    分析：A：先让两个指针一个跑一步，一个每次跑两步，然后找到第一次相遇点
        B:再让其中一个指向head，然后一人走一步，再次相遇，相遇的地方便是出口
    */
    public Node detectCycle(Node head) {
        Node slow = head;
        Node fast=head;
        while(slow!=null&&fast!=null&&fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast){
                break;  //说明有环，这是现在的相遇点
            }
        }
        if(slow==null||fast==null||fast.getNext()==null){
            return null;    //说明没有环
        }
        slow=head;
        while(slow!=fast){
            slow=slow.getNext();
            fast=fast.getNext();
        }
        return slow;
    }


    //给定一个链表，判断链表中是否有环
    /*
    分析：定义两个指针，一个每次走一步，一个每次走两步
        最后如果相遇了，那说明有环，如果走的快的指针p
        p==null||p.next=null,那就说明没有环
     */
    public static boolean hasCyclic(Node head){
        Node slow = head;
        Node fast = head;
        while(slow!=null&&fast!=null&&fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast){
                return true;
            }
        }
        return false;
    }



    //判断一个链表是否是回文结构
    /*
    先找到链表的中间节点
    然后从中间节点往后开始逆置，逆置结束后，
    然后一个指针从前往后，一个指针从后往前，循环退出条件就是，两个指向同一个了
    循环里要判断，如果两个指针的next相等，那说明该链表是偶数，也是个回文结构，返回ture
     */
    public static boolean isPalindrome(Node head){
        //先寻找链表的中间节点
        Node slow = head;
        Node fast = head;
        while (fast!=null&&fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
        }
        //现在slow就是链表的中间节点，如果是偶数，例如链表四个节点，就是第3个
        //逆置slow后面的节点
        Node cur = slow.getNext();
        while(cur!=null){
            Node curRight = cur.getNext();  //保存cur下一个节点位置
            cur.setNext(slow);  //让cur反向指向slow
            slow=cur;   //把slow移动到cur位置
            cur=curRight;   //cur后移
        }
        //现在slow就是最后一个节点，现在slow和head向中间靠拢
        while(slow!=head){
            if(slow.getData()!=head.getData()){
                return false;
            }
            //表示偶数的时候
            if(head.getNext()==slow){
                return true;
            }
            slow=slow.getNext();
            head=head.getNext();
        }
        return true;    //表示链表基数
    }


    //在一个排序的链表中，存在重复的节点，
    // 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    //例如，链表1-2-3-3-4-4-5处理后为1-2-5
    /*
    分析：定义一个傀儡节点，让他接收不重复的节点，
        最后返回它的next
     */
    public static Node deleteDuplication(Node pHead){
        Node newNode = new Node(0); //傀儡节点
        Node curNew = newNode;  //遍历傀儡节点
        Node cur = pHead;   //遍历链表
        while(cur!=null){
            if(cur.getNext()!=null&&cur.getData()==cur.getNext().getData()){
                while(cur.getNext()!=null&&cur.getData()==cur.getNext().getData()){
                    cur=cur.getNext();
                }
                cur=cur.getNext();
            }else{
                curNew.setNext(cur);
                curNew=curNew.getNext();
                cur=cur.getNext();
            }
        }
        curNew.setNext(null);
        return newNode.getNext();
    }


    //编写代码，以给定值x为基准将链表分割成两部分，
    //所有小于x的节点排在大于或等于x的节点之前
    //给定一个链表的头指针ListNode pHead，请返回重新排序后的链表的头指针。
    // 注意：分割以后保持原来的数据顺序不变
    /*
    分析：定义两个新链表，一个链表存储比x节点小的，另一个链表存储比x节点大于或等于的
        但是每一次存进去，都需要进行尾插法，因为上面的注意！！！
        最后两个链表一连接即可
     */
    public static Node partition(Node pHead, int x){
        //表示一个链表的头和尾,存储比x节点小的
        Node beforeStart = null;
        Node beforeEnd=null;
        //同上，存储比x节点大于等于的
        Node afterStart = null;
        Node afterEnd = null;
        while(pHead!=null){
            if(pHead.getData()<x){
                //现在判断before链表是否为空
                if(beforeStart==null){
                    //表示第一次添加
                    beforeStart=pHead;
                    beforeEnd=pHead;
                }else{
                    //表示不是第一次添加
                    beforeEnd.setNext(pHead);
                    beforeEnd=beforeEnd.getNext();
                }
            }else {
                //现在判断after链表是否为空
                if(afterStart==null){
                    //表示第一次添加
                    afterStart=pHead;
                    afterEnd=pHead;
                }else{
                    //表示不是第一次添加
                    afterEnd.setNext(pHead);
                    afterEnd = afterEnd.getNext();
                }
            }
            pHead=pHead.getNext();  //后移
        }
        //退出循环后，需要判断是否第一个链表为null
        //如果为null，说明全是比x值大的，直接返回第二条链表即可
        if(beforeStart==null){
            return afterStart;
        }
        beforeEnd.setNext(afterStart);  //把两个链表连接起来
        if(afterEnd!=null) {
            afterEnd.setNext(null); //把第二个链表的最后一个元素的next域置空
        }
        return beforeStart; //返回第一个链表的第一个有效节点
    }
}
