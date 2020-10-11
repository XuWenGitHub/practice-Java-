package practice.six;

/**
 * @PackgeName: practice.six
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/11 21:16
 * Introduce:
 */
public class Demo {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /*
    根据二叉树创建字符串
    如果当前节点有两个孩子，那我们在递归时，需要在两个孩子的结果外都加上一层括号；
    如果当前节点没有孩子，那我们不需要在节点后面加上任何括号；
    如果当前节点只有左孩子，那我们在递归时，只需要在左孩子的结果外加上一层括号，而不需要给右孩子加上任何括号；
    如果当前节点只有右孩子，那我们在递归时，需要先加上一层空的括号 () 表示左孩子为空，再对右孩子进行递归，并在结果外加上一层括号。
    */
    public String tree2str(TreeNode t) {
        return treeCreate(t,new StringBuilder()).toString();
    }
    public StringBuilder treeCreate(TreeNode t,StringBuilder sb){
        if(t==null){    //当树是空树
            return sb;
        }else if(t.left==null&&t.right==null){  //当树只有一个节点
            return sb.append(t.val);
        }else if(t.right==null&&t.left!=null){  //当树没有右子树有左子树
            //右子树就不需要带括号
            return sb.append(t.val).append("(").append(tree2str(t.left)).append(")");
        }else { //其他情况
            //左子树需要带括号，右子树也需要带括号
            return sb.append(t.val).append("(").append(tree2str(t.left)).append(")(").append(tree2str(t.right)).append(")");
        }
    }
}
