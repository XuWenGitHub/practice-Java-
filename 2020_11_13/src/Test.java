public class Test {
    public static void main(String[] args) {
//        System.out.println("sadasd");
//        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node5;
        node2.left = node1;
        node2.right = node3;
        node5.right = node6;
        infixOrder1(root);  //前序遍历二叉搜索树
        System.out.println();
        TreeNode head = treeToTwoLinked(root);  //得到升序的双向链表
//6->5->4->3->2->1
        while(head!=null){
            System.out.print(head.val+"->");
            head = head.left;
        }

    }
    //树的中线遍历
    public static void infixOrder1(TreeNode root){
        if(root!=null){
            infixOrder1(root.left);
            System.out.print(root.val);
            infixOrder1(root.right);
        }
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /*
    输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表，
    要求不能创建任何新的节点，只能调整树中节点指针的指向
     */
    /*
    分析：
    1.中序遍历是不是有序的
     */
    static TreeNode head;  //这个就是返回双向链表的头结点
    static TreeNode prev;  //这个就是中序遍历中，每一次，的上一个节点，1,3,5,6
    public static TreeNode treeToTwoLinked(TreeNode root){
        head = null;
        prev = null;
        infixOrder(root);
        return head;
    }

    //这个就是中序遍历
    public static void infixOrder(TreeNode root){
        if(root!=null){
            infixOrder(root.right);
            if(head==null){ //保存双向链表的头结点
                head = root;
            }
            if(prev==null){ //前驱等于空，那就说明是第一个节点
                //prev.right = head;
                root.right = null;
            }else { //说明不是第一个节点，因为有前驱节点
                prev.left = root;
                root.right = prev;
            }
            prev = root;
            infixOrder(root.left);
        }
    }
}
