package practice.three;


import java.util.Deque;
import java.util.LinkedList;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}


class Solution {
    //判断B是不是A的子结构
    //在A树中找B节点，用dfs，后序遍历查找,找到后判断两棵树是否一样，如果一样返回true，如果不一样返回false，如果是false，就继续找
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null){
            return false;
        }
        boolean left = isSubStructure(A.left,B);
        boolean right = isSubStructure(A.right,B);
        if(!left&&!right&&A.val==B.val){
            //!left&&!right非常重要，一定要判断，不然如果一棵树里有两个和B根节点相同的节点，
            // 判断了一个是true后，最后判断的上面如果有根节点相同但是结构不同的，这个true就会被覆盖
            return isSame(A,B);
        }
        return left||right;
    }
    //判断两颗树是否一样
    public boolean isSame(TreeNode A, TreeNode B){
        if(A==null&&B==null){
            return true;
        }
        if(B==null&&A!=null){
            return true;
        }
        if(B!=null&&A==null){
            return false;
        }
        return A.val==B.val&&isSame(A.left,B.left)&&isSame(A.right,B.right);
    }

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
}
