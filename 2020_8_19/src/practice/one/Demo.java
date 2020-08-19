package practice.one;

import java.util.Arrays;

class A{
    public void math(){
     System.out.println("sadas");
    }
}
class B extends A{
    @Override
    public void math() {
        super.math();
    }
}
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/19 12:07
 * Introduce:
 */
public class Demo {
    public static void list(Node head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        System.out.println(add(5,5));
//        System.out.println(8>>>1);
//        int[] arr={1,3,5,-1,2,3,0,10,21,9};
//        for(int i=1;i<arr.length;i++){
//            int tem = arr[i];   //待插入元素
//            int j;
//            for(j=i-1;j>=0;j--){
//                if(tem<arr[j]){
//                    arr[j+1]=arr[j];
//                }else{
//                    break;  //表示找到位置，再j的后面插入
//                }
//            }
//            arr[j+1]=tem;
//        }
//        System.out.println(Arrays.toString(arr));

        Node head = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        Node node6 = new Node(23);
        Node node7 = new Node(10);
        Node node8 = new Node(-1);
//        node6.next = node7;
//        node7.next = head;
//        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node4.next = node8;

        node5.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = head;

        list(node5);
        list(sortNode(node5));

//        int[] arr = {3,2,1,4,1};
//        System.out.println(findArrN(arr,5));
    }
    //给定一个整型数组和一个整数n，找到该数组中和为n的连续的子数组的个数。
    /*
    示例 1 : 输入:array = [1,1,1], n = 2 输出: 2
    因为： [1,1] 与 [1,1] 为两种不同的情况。
    示例 2 : 输入:array = [3,2,1,4,1], n = 5 输出: 3
    因为： [3,2] 与 [1,4], [4,1]
     */
    public static int findArrN(int[] arr,int n){
        int num=0;  //表示子数组的个数
        for(int left=0;left<arr.length;left++){
            int result = arr[left];   //子数组的和
            if(result==n){
                num++;
            }
            int right=left+1;   //left的下一个
            while(right<arr.length){
                result+=arr[right];
                if(result==n){
                    num++;
                }
                right++;
            }
        }
        return num;
    }


    //给定一个不带头结点的单链表，对链表进行插入排序(从小到大排序)
    /*
    从第二个节点开始插入
    A：造一个傀儡节点，int就为最小的值，然后连接head，这样就可以避免，插入的位置是第一个
    B：现在已经确定插入的位置不是第一个，定义一个cur从傀儡节点开始遍历,
    C：判断cur.next!=null&&cur.next.val<=待插入元素的val,那么cur后移
    D：如果cur.next.val>val,说明待插入节点应该插入到cur后面，先不要急着插入，先把待删除节点删除，插入到cur后面
     */
    public static Node sortNode(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node puppet = new Node(Integer.MIN_VALUE);
        puppet.next = head;
        Node curPrev = puppet.next;  //保存cur的前驱节点，因为如果cur要移动位置，就要先在链表中删除cur
        Node cur = puppet.next.next;    //第2个有效节点,从第二个有效号节点开始插入
        while(cur!=null){   //从第二个有效节点开始往前插入
            boolean flag = false;   //表示是否待插入元素位置变换
            Node curNext = cur.next;    //下一个待插入的节点

            //cur是待插入节点,prev是找到待插入位置
            Node prev = puppet;
            while(prev.next.val <= cur.val && prev.next != cur){
                prev = prev.next; //后移
            }

            if(prev.next.val > cur.val && prev.next != cur){
                //说明cur应该插入到prev后面
                curPrev.next = cur.next;    //先删除cur
                Node prevNext= prev.next;
                prev.next = cur;    //添加cur
                cur.next = prevNext;
                flag = true;
            }
            if (!flag) {
                curPrev = cur;
            }
            cur = curNext;
        }
        return puppet.next;
    }

    //给定一个链表(不带头结点)，删除链表的倒数第K个节点，并且返回链表的头结点。时间复杂度O(n)
    //示例：1->2->3->4->5 删除倒数第2个节点后 变1->2->3->5
    /*
    分析：
    A：定义快慢指针，快指针先走k步，然后两个指针一起走，当快指针走到自己为null时，说明慢指针先走就是待删除的节点
    B：但是我们要做一个慢指针的前驱节点，一开始为null，最后方便删除，如果最后还是为null，说明删除的是头节点
     */
    public Node removeKthNode(Node head,int k){
        if(head==null||k<1){
            return null;    //表示数据有误
        }
        Node fast = head;
        Node slow = head;
        Node slowPrev = null;
        for(int i=0;i<k;i++){
            if(fast==null){
                return null;    //表示k，给的超出链表的长度了
            }
            fast = fast.next;
        }
        while(fast!=null){
            slowPrev = slow;
            slow=slow.next;
            fast = fast.next;
        }
        //删除slow节点
        if(slowPrev==null){
            head = head.next;
            return head;
        }
        slowPrev.next = slow.next;
        return head;
    }

    /*
    写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
    两个数字先&再<<1位，这就是两个数的进位
    两个数直接^，这就是两个数二进制相加，但是没有考虑进位
    java中的异或运算符号是 ^   二进制加法，不考虑进位，就是异或运算。可自行验证
    java中的左移运算符，在左移后最右边补0。按位与运算再左移一位，恰符合进位的实际情况
     */
    public static int add(int num1,int num2){
        while(num2!=0){
            int res = (num1&num2)<<1;   //这是num1和num2的进位
            num1 = num1^num2;   //二进制加法，不考虑进位
            num2=res;
        }
        return num1;
    }
}
