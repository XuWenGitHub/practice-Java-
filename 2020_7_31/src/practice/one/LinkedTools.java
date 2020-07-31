package practice.one;

public class LinkedTools {





    //将两个有序链表合并为一个新的有序链表并返回
    //新链表是通过拼接给定的两个链表的所有节点组成的
    /*
    先构造一个傀儡节点
    然后来两个引用,遍历两个有序链表
    然后判断哪个大，大的就添加到傀儡节点的后面
    但是要注意：要把哪个链表中的节点添加到傀儡节点的后面的时候
    一定要保存当前链表被添加节点的下一个节点的位置
     */
    public static Node mergeTwoLists(Node headA,Node headB){
        if(headA==null||headB==null){
            return headA==null?headB:headA;
        }
        Node newNode = new Node(-1);    //傀儡节点
        Node newNodeCur = newNode;  //遍历傀儡链表,因为最后要返回newNode的next
        Node curA = headA;
        Node curB = headB;
        //直到有一个链表为空
        while (curA != null && curB != null) {
            //现在判断大小
            if (curA.getData() < curB.getData()) {
                newNodeCur.setNext(curA);
                newNodeCur = newNodeCur.getNext();
                curA = curA.getNext();
            } else {
                newNodeCur.setNext(curB);
                newNodeCur = newNodeCur.getNext();
                curB = curB.getNext();
            }
        }
        //当循环退出有两种情况
        //第一种，curA为null，第二种，curB为null
        if(curB!=null){
            newNodeCur.setNext(curB);
        }else {
            newNodeCur.setNext(curA);
        }
        return newNode.getNext();
    }




    //寻找两个链表相交的第一个点，
    //如果没有相交点返回null
    /*
    分析：先找出A和B链表的长度
        让长度长的先走差值步
        然后两个一起走，第一次相遇就是相交点
        如果其中一个走到null了，那说明没有相交点返回null
     */
    public static Node getIntersectionNode(Node headA,Node headb){
        if(headA==null||headb==null){
            return null;
        }
        //分别求出两个链表的长度
        int countA=0;
        int countB=0;
        Node curA = headA;
        Node curB=headb;
        while(curA!=null){
            countA+=1;
            curA=curA.getNext();
        }
        while (curB!=null){
            countB+=1;
            curB=curB.getNext();
        }
        curA=headA; //置为A链表第一个有效节点
        curB=headb; //置为B链表第一个有效节点
        //现在先让长度长的走n步
        if(countA>countB){
            for(int i=0;i<countA-countB;i++){
                curA=curA.getNext();
            }
        }else{
            for(int i=0;i<countB-countA;i++){
                curB=curB.getNext();
            }
        }
        //现在长的已经走了差值步，现在两个引用一人一步走
        while(curA!=null&&curB!=null){
            if(curA==curB){
                return curA;    //如果相遇返回第一次相遇的交点
            }
            curA=curA.getNext();
            curB=curB.getNext();
        }
        return null;    //表示没有交点
    }
}
