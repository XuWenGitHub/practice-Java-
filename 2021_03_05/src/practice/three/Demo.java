package practice.three;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    int size;

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode node = getKthFromEnd(head.next, k);
        if (++size == k)
            return head;
        return node;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(new Demo().getKthFromEnd(node1,2).val);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list1 = list.subList(0, 0);
        System.out.println(list1);
        String a = "a";
        String b = "a";
        System.out.println(a==b);
    }
    //一个青蛙，一次可以跳一个台阶，也可以一次跳n个台阶
    //问一个超级青蛙，跳n个台阶有多少种跳法
    //加入青蛙，最后一步跳一隔,最后一步跳两格台阶....
    //f(n) = f(n-1)+f(n-2)+....+f(2)+f(1)+f(0)
    //f(n-1) = f(n-2)+...+f(2)+f(1)+f(0)
    //f(n) = 2*f(n-1)
    public int jump(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        return 2*jump(n-1);
    }

    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return new int[0];
        }
        arr = new int[matrix.length*matrix[0].length];  //最后返回的数组
        index = 0;
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        arr[0] = matrix[0][0];
        isVisited[0][0]= true;
        goMiGong(matrix,isVisited,0,0);

        return arr;
    }
    static int[] arr;   //返回的数组
    static int index;   //数组的下标

    //递归处理,要有一个boolean类型数组
    public void goMiGong(int[][] matrix, boolean[][] isVisited, int i, int j) {
        //上->右->下->左
        if (((j + 1) < matrix[i].length && !isVisited[i][j + 1])) {   //上
            while ((j + 1) < matrix[i].length && !isVisited[i][j + 1]) {
                index++;
                j++;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }
            goMiGong(matrix, isVisited, i, j);
        } else if ((i + 1) < matrix.length && !isVisited[i + 1][j]) {
            while ((i + 1) < matrix.length && !isVisited[i + 1][j]) {
                index++;
                i++;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }

            goMiGong(matrix, isVisited, i, j);
        } else if ((j - 1) >= 0 && !isVisited[i][j - 1]) {
            while ((j - 1) >= 0 && !isVisited[i][j - 1]) {
                index++;
                j--;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }

            goMiGong(matrix, isVisited, i, j);
        } else if ((i - 1) >= 0 && !isVisited[i - 1][j]) {
            while ((i - 1) >= 0 && !isVisited[i - 1][j]) {
                index++;
                i--;
                arr[index] = matrix[i][j];
                isVisited[i][j] = true;
            }
            goMiGong(matrix, isVisited, i, j);
        }
    }
}
