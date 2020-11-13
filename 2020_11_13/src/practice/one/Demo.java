package practice.one;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

    }
    //栈的压入、弹出序列
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int pushIndex = 0;
        int popIndex = 0;
        while(pushIndex<pushed.length&&popIndex<popped.length){
            int pushVal = pushed[pushIndex];
            int popVal = popped[popIndex];
            if(pushVal==popVal){
                popIndex++;
                pushIndex++;
            }else{
                if(stack.isEmpty()){
                    stack.push(pushVal);
                    pushIndex++;
                }else{
                    if(stack.peek()==popVal){
                        stack.pop();
                        popIndex++;
                    }else{
                        stack.push(pushVal);
                        pushIndex++;
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            if(popped[popIndex]==stack.pop()){
                popIndex++;
            }else{
                return false;
            }
        }
        return popIndex==popped.length;


    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //从上到下打印二叉树
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            res.add(cur.val);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
        int[] arr = new int[res.size()];
        int index=0;
        for(Integer element:res){
            arr[index++] = element;
        }
        return arr;
    }
}
