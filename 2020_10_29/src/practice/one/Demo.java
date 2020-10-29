package practice.one;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/29 19:59
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
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>();
        map.put("徐文","老大");
        map.put("王森","老2");
        map.put("扶摇","老3");
        map.put("小杰","老4");
        map.put("飞哥","老5");
        map.put("亚鹏","老6");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
    public static Node copy(Node head){
        Node puppet = new Node(-1);
        Node puppetCur = puppet;
        while(head!=null){
            puppetCur.next = new Node(head.val);
            head = head.next;
            puppetCur = puppetCur.next;
        }
        return puppet.next;
    }
    //宝石与石头
    public int numJewelsInStones(String J, String S) {
        int res=0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<J.length();i++){
            set.add(J.charAt(i));
        }
        for(int i=0;i<S.length();i++){
            if(set.contains(S.charAt(i))){
                res++;
            }
        }
        return res;
    }


    /*
    给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的 深拷贝。 
我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

    第一步，根据遍历到的原节点创建对应的新节点，每个新创建的节点是在原节点后面
    第二步，原节点1的随机指针指向原节点3，新节点1的随机指针指向的是原节点3的next
原节点3的随机指针指向原节点2，新节点3的随机指针指向的是原节点2的next
    第三步，将两个链表分离，然后返回新的链表即可
    */
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur = head;
        //给链表每一个节点的后面复制一个新的节点
        while(cur!=null){
            Node curCopy = new Node(cur.val);   //复制了当前节点
            //将新节点添加到当前节点后面
            Node curNext = cur.next;
            cur.next=curCopy;
            curCopy.next=curNext;
            //cur后移
            cur = cur.next.next;
        }
        //给新的节点赋random值
        cur = head;
        while(cur!=null){
            Node curNext = cur.next;
            if(cur.random!=null){
                curNext.random=cur.random.next;
            }
            cur = cur.next.next;
        }
        //链表分离,分离时要保证，恢复原来链表的样子
        Node newNode = new Node(-1);
        Node newNodeCur = newNode;
        cur = head;
        while(cur!=null){
            Node curNext = cur.next;
            cur.next = cur.next.next;

            newNodeCur.next = curNext;
            newNodeCur = curNext;

            cur = cur.next;
        }
        newNodeCur.next = null;
        return newNode.next;
    }

    //找数组中唯一出现的一个数字
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int element:nums){
            result^=element;
        }
        return result;
    }
}
