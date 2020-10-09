package practice.three;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/9 16:56
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //判断一个二叉树的两个节点是否是堂兄弟节点
    //就是两个节点在同一层，但是父节点不同
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null||root.val==x||root.val==y){
            return false;   //当root为空或者x和y其中一个是根节点，那么一定没有堂兄弟
        }
        TreeNode xNode = null;  //x节点
        TreeNode yNode = null;  //y节点
        TreeNode xFather = null;    //x父节点
        TreeNode yFather = null;    //y父节点
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){    //遍历每一层
                TreeNode cur = queue.poll();    //队列中取出一个
                //先判断是不是x父节点或者y父节点
                if(cur.left!=null){
                    queue.offer(cur.left);    //把下一层的填入队列
                    if(cur.left.val==x){    //判断是不是x的父节点
                        xFather = cur;
                        xNode = cur.left;
                    }
                    if(cur.left.val==y){    //判断是不是y的父节点
                        yFather = cur;
                        yNode = cur.left;
                    }
                }
                if(cur.right!=null){
                    queue.offer(cur.right);   //把下一层的填入队列
                    if(cur.right.val==x){   //判断是不是x的父节点
                        xFather = cur;
                        xNode = cur.right;
                    }
                    if(cur.right.val==y){   //判断是不是y的父节点
                        yFather = cur;
                        yNode = cur.right;
                    }
                }
                if(xNode==null&&yNode==null){   //说明两个节点都没有找到
                    //目前两个都没找到,什么都不需要做
                }else if(xNode==null||yNode==null){ //说明只找到其中一个节点
                    if(i==size-1){  //如果是true，说明这一层只找到一个节点，那就返回false
                        //!!!(i==size-1)，一定要加上这个，这样才能说明是最后一层最后一个节点的判断
                        return false;   //表示两个不在同一层
                    }
                }else{  //说明两个都不为null
                    return xFather!=yFather;    //如果父节点不同，那么就为真
                }
            }
        }
        //走到这里说明二叉树中没有找到x和y
        return false;
    }

    //给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        getValue(root,list);    //现在把树中从小到大存储到values里面了
        int sum = 0;    //保存当前移动窗口的值
        int left=0;
        int right = list.size()-1;
        while(left<right){
            sum = list.get(left)+list.get(right);
            if(sum<k){
                left++;
            }else if(sum>k){
                right--;
            }else{
                return true;
            }
        }
        return false;

    }
    public void getValue(TreeNode root,List<Integer> list){   //中序遍历二叉搜索树，把每个值存储到list返回
        if(root!=null){
            getValue(root.left,list); //左子树的元素
            list.add(root.val);
            getValue(root.right,list);   //右子树的元素
        }
    }
}
