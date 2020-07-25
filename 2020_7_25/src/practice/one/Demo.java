package practice.one;
/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
//节点类
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class Demo {
    public static void main(String[] args) {

    }
    //分析：
    //注解：count=0 //表示每次相加往后进位进多少
    //A：先把l1和l2第一个数都去取出来，取出来后，然后加一起再加上count，用value来保存
    //B：每次value%10，就是当前要存的数，value/10就是下一次进位的数
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1; //遍历l1链表的辅助节点,指向一个有效节点
        ListNode cur2 = l2; //遍历l2链表的辅助节点，指向第一个有效节点
        int value = cur1.val+cur2.val;  //表示加起来的和
        ListNode list = new ListNode(value%10); //最后传出去的链表
        int count=value/10; //两个数的的和如果大于10，保留在这里，留给下一个数
        ListNode cur3 = list;//遍历新建链表的辅助节点,现在指向第一个有效节点
        //已经弄了第一个数了，现在cur1和cur2都后移一下,现在cur1和cur2指向第二个节点
        cur1=cur1.next;
        cur2=cur2.next;

        //直到有一个链表为空，才推出循环,最后退出循环后，count不一定为空
        while(true){
            if(cur1==null||cur2==null){
                break;
            }
            value=count+cur1.val+cur2.val;  //把两数之和和count存入了value
            cur3.next= new ListNode(value%10);  //list指向下一个数
            cur3=cur3.next; //现在cur3又后移一下
            count=value/10; //保留value现在往前进位的数字
            cur1 = cur1.next;   //cur1后移
            cur2 = cur2.next;   //cur2后移一下
        }

        //退出上面循环表示，cur1或者cur2变成null了,此时count可能有剩余
        if(cur1==null&&cur2!=null){
            //表示count没有结束
            while(true){
                if(count==0||cur2==null){
                    break;
                }
                value=count+cur2.val;
                cur3.next=new ListNode(value%10);
                cur3=cur3.next; //现在cur3又后移一下
                count=value/10; //保留value现在往前进位的数字
                cur2=cur2.next;
            }
            if(count==0){//说明count为0，把cur2后面的接到cur3后面
                cur3.next=cur2;
            }else{//说明count！=0，但是cur2为null了，那就在最后接上count
                cur3.next = new ListNode(count);
            }
        }else if(cur2==null&&cur1!=null){
            //表示count没有结束
            while(true){
                if(count==0||cur1==null){
                    break;
                }
                value=count+cur1.val;
                cur3.next=new ListNode(value%10);
                cur3=cur3.next; //现在cur3又后移一下
                count=value/10; //保留value现在往前进位的数字
                cur1=cur1.next;
            }
            if(count==0){//说明count为0，把cur2后面的接到cur3后面
                cur3.next=cur1;
            }else{//说明count！=0，但是cur2为null了，那就在最后接上count
                cur3.next = new ListNode(count);
            }
        }else{
            if(count!=0){
                cur3.next = new ListNode(count);
            }
        }
        return list;
    }
}
