package practice.four;

/**
 * @PackgeName: practice.four
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/11 18:08
 * Introduce:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向
 */
public class Demo {
    static class TreeNode{
        int val;
        TreeNode left;  //代表双向链表的prev
        TreeNode right; //代表双向链表的next

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //深度优先搜索将一个二叉搜索树形成一个从小到大的双向链表，不能创建新的节点
    private TreeNode head;
    private TreeNode tail;
    public void dfs(TreeNode root){
        if(root!=null){
            dfs(root.left);
            if(head==null){
                head = root;
            }
            root.left = tail;
            if(tail!=null){
                tail.right = root;
            }
            tail = root;
            dfs(root.right);
        }
    }
    /*
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    要求不能创建任何新的结点，只能调整树中结点指针的指向
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        head = null;
        tail = null;
        dfs(pRootOfTree);
        return head;
    }

}
