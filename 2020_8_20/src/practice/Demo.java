package practice;

/**
 * @PackgeName: practice
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/20 10:17
 * Introduce:
 */
public class Demo {
    public static void list(Node head){
        while(head!=null){
            System.out.print(head.val+" ");
            head= head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node node = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        list(node);
        list(insertSortLinked(node));

    }
    /*
    单链表插入排序
    分析：
    A：造一个傀儡节点puppet,然后连接head，这样就可以，不用判断是不是需要插入到head位置
    B：然后找位置，找到or找不到     cur:待插入节点， tem：待插入位置
    C：找到：例如3,10 要插入中间，最开始要保存待插入节点的prev，因为如果要插入，就需要先删除
        删除后，然后先保存tem的下一个和cur的下一个，然后tem.next = cur;
        cur.next = temNext;
    D：cur和curPrev后移时候，cur位置没动，curPrev才需要移动，cur也需要移动
     */
    public static Node insertSortLinked(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node puppet = new Node(Integer.MIN_VALUE);
        puppet.next = head;
        Node cur = head.next;   //待插入节点，从第二个有效元素开始
        Node curPrev = puppet.next;
        while(cur!=null){
            boolean flag = false;   //看是否找到待插入的位置
            Node curNext = cur.next;

            Node tem = puppet;  //找到待插入位置
            while(tem.next!=cur&&tem.next.val<=cur.val){    //找到待插入位置，应该插入到tem的后面
                tem = tem.next;
            }
            if(tem.next.val > cur.val){//需要发生插入
                curPrev.next = cur.next;    //删除当前节点
                Node temNext= tem.next; //保存目前待插入位置的下一个
                tem.next = cur; //tem指向cur
                cur.next = temNext; //cur指向最temNext
                flag = true;    //如果发生插入了，当前待插入元素，已经删除了，所以下一个待插入元素位置没有发生变化
            }

            if(!flag){  //如果cur位置没有变，才发生变化
                curPrev = cur;
            }
            cur = curNext;  //cur后移
        }
        return puppet.next;
    }
}
