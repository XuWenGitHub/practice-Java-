package practice.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void list(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.print(poll == null ? null+" " : poll.val + " ");
                if (poll != null) {
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(6) / fib(4) / fib(3));
        Solution solution = new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(3);
        for(TreeNode cur:treeNodes){
            list(cur);
            System.out.println();
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0) {
            return ans;
        }
        TreeNode root = new TreeNode(0); //作为一个哨兵节点
        getAns(n, ans, root, 0);
        return ans;
    }

    private void getAns(int n, List<TreeNode> ans, TreeNode root, int count) {
        if (count == n) {
            //复制当前树并且加到结果中
            TreeNode newRoot = treeCopy(root);
            ans.add(newRoot.right);
            return;
        }
        TreeNode root_copy = root;
        //尝试插入每个数
        for (int i = 1; i <= n; i++) {
            root = root_copy;
            //寻找要插入的位置
            while (root != null) {
                //在左子树中插入
                if (i < root.val) {
                    //到了最左边
                    if (root.left == null) {
                        //插入当前数字
                        root.left = new TreeNode(i);
                        //进入递归
                        getAns(n, ans, root_copy, count + 1);
                        //还原为 null，尝试插入下个数字
                        root.left = null;
                        break;
                    }
                    root = root.left;
                    //在右子树中插入
                } else if (i > root.val) {
                    //到了最右边
                    if (root.right == null) {
                        //插入当前数字
                        root.right = new TreeNode(i);
                        //进入递归
                        getAns(n, ans, root_copy, count + 1);
                        //还原为 null，尝试插入下个数字
                        root.right = null;
                        break;
                    }
                    root = root.right;
                    //如果找到了相等的数字，就结束，尝试下一个数字
                } else {
                    break;
                }
            }
        }
    }

    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cur = new TreeNode(root.val);
        ;
        TreeNode l = treeCopy(root.left);
        TreeNode r = treeCopy(root.right);
        cur.left = l;
        cur.right = r;
        return cur;
    }


    public static int fib(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fib(n - 1);
    }
}
