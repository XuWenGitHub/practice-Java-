class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class Demo4 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        String s;
        //System.out.println(s);
    }
    //给出两个 非空 的链表用来表示两个非负的整数。
    // 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    //如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    //输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //输出：7 -> 0 -> 8
    //原因：342 + 465 = 807
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode linked = new ListNode(0) ;
        ListNode cur = l1;
        int digit1=0;   //表示第一个数有多少位
        int digit2 = 0; //表示第二个数有多少位
        int value=0;    //两个数的和
        while(cur!=null){
            digit1++;
            cur=cur.next;
        }
        cur=l2;
        while(cur!=null){
            digit2++;
            cur=cur.next;
        }

        cur=l1;
        while(cur!=null){
            digit1--;
            int one = cur.val*((int)Math.pow(10,digit1));
            value+=one;
        }
        cur=l2;
        while(cur!=null){
            digit2--;
            int two = cur.val*((int)Math.pow(10,digit2));
            value+=two;
        }
        //现在的value就是两者加的值,现在判断value的位数
        int temp=value;
        int valueDigit = 0;
        while(true){
            if(temp>=0&&temp<=9){
                valueDigit++;
                break;
            }
            temp/=10;
            valueDigit++;
        }
        ListNode cur2 = linked;
        for(int i=0;i<valueDigit;i++){
            int v=(value/((int)Math.pow(10,i)))%10;
            ListNode ll=new ListNode(v);
            if(i==0){
                linked=ll;
            }else{
                cur2.next=ll;
                cur2=cur2.next;
            }
        }
        return linked;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        //分析：
        //A：先把l1和l2的第一个都取出来，然后相加，得到的数可能是个一位数，也可能是个两位数
        //B：如果是一位数的话：直接除10取模，然后存入新的节点
        //C：如果是两位数的话，count++；count表示下一个进1
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode list = new ListNode(0);
            int count=0;
            ListNode cur1 = l1; //遍历l1链表的辅助节点
            ListNode cur2 = l2; //遍历l2链表的辅助节点
            ListNode cur3 = list;//遍历新建链表的辅助节点
            int value = cur1.val+cur2.val;  //表示加起来的和
            if(value<=9&&value>=0){
                ListNode ll = new ListNode(value);
                list=ll;
                cur3=ll;
            }else{
                value%=10;
                count+=1;
            }
            //cur3=cur3.next;
            cur1=cur1.next;
            cur2=cur2.next;
            //直到有一个链表为空
            while(true){
                if((cur1==null||cur2==null)&(count==0)){
                    break;
                }

                if(cur1!=null&&cur2!=null){
                    value=cur1.val+cur2.val+count;
                }else{
                    value=count;
                }

                if(value<=9&&value>=0){
                    //说明是一位数
                    cur3.next=new ListNode(value);
                    count=0;    //把向前进位变成0
                }else{
                    //说明是两位数
                    count=value/10;
                    cur3.next=new ListNode(value%10);
                }
                cur3=cur3.next;
                if(cur1!=null&&cur2!=null){
                    cur1=cur1.next;
                    cur2=cur2.next;
                }
            }
            //退出上面循环表示，cur1或者cur2变成null了
            if(cur1==null&&cur2!=null){
                //把cur2全拼接到后面
                cur3.next=cur2;
            }else if(cur2==null&&cur1!=null){
                cur3.next=cur1;
            }else{

            }
            return list;


            // ListNode linked = new ListNode() ;
            // ListNode cur = l1;
            // int digit1=0;   //表示第一个数有多少位
            // int digit2 = 0; //表示第二个数有多少位
            // long value=0;    //两个数的和
            // //判断两个数的位数
            // while(cur!=null){
            //     digit1++;
            //     cur=cur.next;
            // }
            // cur=l2;
            // while(cur!=null){
            //     digit2++;
            //     cur=cur.next;
            // }

            // //算出两个数的和，加到value里面
            // cur=l1;
            // for(int i=0;i<digit1;i++){
            //     value+=(cur.val*((long)Math.pow(10,i)));
            //     cur=cur.next;
            // }
            // cur=l2;
            // for(int i=0;i<digit2;i++){
            //     value+=(cur.val*((long)Math.pow(10,i)));
            //     cur=cur.next;
            // }
            // //现在的value就是两者加的值,现在判断value的位数
            // long temp=value;
            // int valueDigit = 0;
            // while(true){
            //     if(temp>=0&&temp<=9){
            //         valueDigit++;
            //         break;
            //     }
            //     temp/=10;
            //     valueDigit++;
            // }
            // ListNode cur2=linked;
            // for(int i=0;i<valueDigit;i++){
            //     //int v=(value/((int)Math.pow(10,i)))%10;
            //     long v=value%10;
            //     value/=10;
            //     ListNode ll=new ListNode((int)v);
            //     if(i==0){
            //         linked=ll;
            //         cur2=ll;
            //     }else{
            //         cur2.next=ll;
            //         cur2=cur2.next;
            //     }
            // }
            // return linked;
        }
    }
}
