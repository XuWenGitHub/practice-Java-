package practice.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/31 23:47
 * Introduce:
 */
public class Demo {
    static class Node{
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
        }
    }
    public static Node add(Node head){
        Node cur = head;
        while (cur!=null){
            Node newNode = new Node(cur.val);
            Node curNext = cur.next;
            cur.next = newNode;
            newNode.next = curNext;
            cur = curNext;
        }
        cur = head;
        Node newCur = head.next;
        while (cur!=null){
            Node oldRandom = cur.random;
            if(oldRandom!=null){
                newCur.random = oldRandom.next;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        //分离两个链表
        Node puppet = new Node(-1);
        Node puppetCur = puppet;
        cur = head;
        while (cur!=null){
            puppetCur.next = cur.next;
            cur.next = cur.next.next;
            puppetCur.next.next = null;
            cur = cur.next;
            puppetCur = puppetCur.next;
        }
        return puppet.next;
    }
    public static Node copyRandomList(Node head) {

        Node cur = head;
        while (cur!=null){
            Node newNode = new Node(cur.val);
            Node curNext = cur.next;
            cur.next = newNode;
            newNode.next = curNext;
            cur = curNext;
        }

        cur = head;
        Node newCur = head.next;
        while (cur!=null){
            Node oldRandom = cur.random;
            if(oldRandom!=null){
                newCur.random = oldRandom.next;
            }
            cur = newCur.next;
            if(cur!=null) {
                newCur = cur.next;
            }
        }
        //分离两个链表
        Node puppet = new Node(-1);
        Node puppetCur = puppet;
        cur = head;
        while (cur!=null){
            puppetCur.next = cur.next;
            cur.next = cur.next.next;
            puppetCur.next.next = null;
            cur = cur.next;
            puppetCur = puppetCur.next;
        }
        return puppet.next;
    }
    public static void main(String[] args) {
        Node head = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node2.random = head;
        node3.random = node5;
        node4.random = node3;
        node5.random = head;
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node node = copyRandomList(head);
    }
    //两数之和
    //遍历一个数，就去map里面找,target-该数的值
    //如果有，就直接返回[i,map.get(findVal)]
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int index=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int findVal = target-nums[i];
            if(map.containsKey(findVal)){
                res[0] = map.get(findVal);
                res[1] = i;
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }

    class Solution {
        //用sum记录添加一个数的和，然后看map里面有没有和sum相同的值，如果没有的话，重新添加，如果有的话，那么就可以计算len了，因为如果前面sum和后面sum相同的话，那么说明是个连续子数组，遇到0减去1，遇到1加上1
        //最开始什么都没有的话，put存0->-1，因为如果下标1再遇到0，便len=(1-(-1));
        public int findMaxLength(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            map.put(0,-1);
            int maxLen = 0;
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                sum=sum+(nums[i]==0?(-1):1);
                if(!map.containsKey(sum)){
                    map.put(sum,i);
                }else{
                    int index = map.get(sum);
                    int len = i-index;
                    maxLen = maxLen>len?maxLen:len;
                }
            }
            return maxLen;
        }

        //判断矩阵中的路径
        //深度优先遍历方法+剪枝解决
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    if(dfs(board,i,j,words,0)){
                        return true;
                    }
                }
            }
            return false;
        }

        //根据下、上、右、左。去深度优先遍历，然后如果四个方向都不成再回溯
        //i，j表示寻找到棋子的下标，word表示寻找的路径，k表示该找到word的第几个了
        public boolean dfs(char[][] board,int i,int j,char[] word,int k){
            if(i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=word[k]){
                return false;
            }
            if(k==word.length-1){
                return true;
            }
            //递归，先保存当前i，j的值
            char temp = board[i][j];
            board[i][j] = '/';  //表示字符意见遍历过了
            boolean res = dfs(board,i+1,j,word,k+1)||dfs(board,i-1,j,word,k+1)||dfs(board,i,j+1,word,k+1)||dfs(board,i,j-1,word,k+1);
            //右下左上
            // boolean res = dfs(board,i,j+1,word,k+1)||dfs(board,i+1,j,word,k+1)||dfs(board,i,j-1,word,k+1)||dfs(board,i-1,j,word,k+1);
            board[i][j]=temp;
            return res;
        }
    }
}
