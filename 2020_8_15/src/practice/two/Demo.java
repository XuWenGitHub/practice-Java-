package practice.two;

import java.util.HashSet;
import java.util.Set;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/15 11:13
 * Introduce:
 */
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
public class Demo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
    }
    /*
    给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
    同时给定列表 G，该列表是上述链表中整型值的一个子集。
    返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。

    示例 1：
    输入:
    head: 0->1->2->3
    G = [0, 1, 3]
    输出: 2
    解释:
    链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
    先把g存入HashSet集合里面，然后让head第一个开始遍历，如果包含，那么判断下一个
    */
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set =new HashSet<>();
        for(Integer i:G){
            set.add(i);
        }
        ListNode cur = head;
        int num=0;
        while(cur!=null){
            if(set.contains(cur.val)){
                while(cur!=null&&set.contains(cur.val)){
                    cur = cur.next;
                }
                num++;
                continue;
            }
            cur = cur.next;
        }
        return num;
    }
}
