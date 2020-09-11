package practice.one;

import java.util.Arrays;

/**
 * @PackgeName: practice.one
 * @ClassName: ListReverse
 * @Author: XuWen
 * Date: 2020/9/10 19:54
 * Introduce:
 */
public class ListReverse {
    public static void main(String[] args) {
        int n=10;
        int[] fib = new int[n+1];
        System.out.println(fib(fib,n));
        System.out.println(Arrays.toString(fib));
    }
    public static int fib(int[] fib,int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(fib[n]>0){
            return fib[n];
        }
        fib[n] = fib(fib,n-1)+fib(fib,n-2);
        return fib(fib,n-1)+fib(fib,n-2);
    }
    public static Node nodeReverse(Node head){
        Node cur = head;
        Node curPrev = null;
        Node temp = null;
        while (cur!=null){
            if(cur.next==null){
                temp = cur;
            }
            Node curNext = cur.next;
            cur.next = curPrev;
            curPrev = cur;
            cur = curNext;
        }
        return temp;
    }
}
