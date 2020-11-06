package practice.one;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.one
 * @ClassName: BinarySearchTree
 * @Author: XuWen
 * Date: 2020/11/6 19:53
 * Introduce:二叉搜索树
 */
public class BinarySearchTree {
    private TreeNode root = null;   //表示二叉搜索树的根节点

    //二叉搜索树，添加操作
    //二叉搜索树，不能有相同的元素
    public boolean add(int val){
        if(root==null){
            root = new TreeNode(val);
            return true;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur!=null){
            pre = cur;
            if(cur.val>val){
                cur = cur.left;
            }else if(cur.val<val){
                cur = cur.right;
            }else{
                return false;   //表示相同元素了
            }
        }

        //从这退出来，pre一定不为null，因为cur一开始不为null
        if(pre.val<val){
            pre.right = new TreeNode(val);
        }else{
            pre.left = new TreeNode(val);
        }
        return true;
    }

    //二叉搜索树，删除某个元素
    public boolean remove(int val){
        TreeNode target = findNode(val);    //去找的目标节点
        if(target==null){
            return false;   //代表没找到目标节点
        }
        TreeNode parent = findParentNode(val);  //目标节点的父节点
        //现在目标节点一定存在，先判断目标节点是不是根节点
        //（1）目标节点是叶子结点
        if(target.left==null&&target.right==null){
            //判断是否有父节点
            if(parent==null){
                root=null;
            }else{
                if(parent.left==target){
                    parent.left=null;
                }else{
                    parent.right = null;
                }
            }
        }else if(target.left!=null&&target.right==null) {
            //(2)目标节点只有左子树
            if(parent==null){
                root = target.left;
            }else{
                if(parent.left==target){
                    parent.left = target.left;
                }else{
                    parent.right = target.left;
                }
            }

        }else if(target.left==null&&target.right!=null){
            //(3)目标节点只有右子树
            if(parent==null){
                root = target.right;
            }else{
                if(parent.left==target){
                    parent.left = target.right;
                }else{
                    parent.right = target.right;
                }
            }
        }else{
            //(3)目标节点有左子树也有右子树
            target.val = delRightMin(target);
        }
        return true;
    }
    //去右子树找一个最小的，然后替带target，然后删除target右子树最小的
    //现在root就是target，并且target有左子树也有右子树
    private int delRightMin(TreeNode root){
        TreeNode cur = root.right;
        TreeNode prev = root;
        while(cur.left!=null){
            prev = cur;
            cur = cur.left;
        }
        if(prev.left==cur){
            prev.left = cur.right;
        }else{
            prev.right=cur.right;
        }
        return cur.val;

    }
    //查找某个节点的父节点，没找到返回null，找到了，返回其父节点
    //如果是找根节点，其父节点为null
    private TreeNode findParentNode(int val){
        if(root==null||root.val==val){
            return null;    //代表没有父节点
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur!=null){
            TreeNode temp = cur;
            if(cur.val>val){
                cur = cur.left;
            }else if(cur.val<val){
                cur = cur.right;
            }else{
                return parent;
            }
            parent = temp;
        }
        return null;
    }

    //查找某个节点，没找到返回null，找到了，返回寻找其节点
    private TreeNode findNode(int val){
        if(root==null){
            return null;
        }
        TreeNode cur = root;
        while (cur!=null){
            if(cur.val<val){
                cur = cur.right;
            }else if(cur.val>val){
                cur = cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }

    //二叉搜索树，查找某个元素
    public boolean find(int val){
        TreeNode node = findNode(val);
        return node!=null;
    }


    //二叉搜索树，中序遍历
    public void infixOrder(){
        if(root==null){
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            cur = pop.right;
        }
    }
}
