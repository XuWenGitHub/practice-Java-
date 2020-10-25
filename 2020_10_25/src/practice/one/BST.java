package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: BST
 * @Author: XuWen
 * Date: 2020/10/25 10:57
 * Introduce:
 */
public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }
    public void add(Integer key){
        if(root==null){
            root = new Node(key);
            return;
        }
        Node parent = null;
        Node cur = root;
        int cmp = 0;
        while (cur!=null){
            cmp = key.compareTo(cur.val);
            if(cmp==0){
                throw new RuntimeException("BST树中不能有值相同的节点");
            }else if(cmp<0){
                parent = cur;
                cur = cur.left;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        if(cmp<0){
            parent.left = new Node(key);
        }else{
            parent.right = new Node(key);
        }
    }

    public boolean search(Integer key){
        Node cur = root;
        while(cur!=null){
            int cmp = key.compareTo(cur.val);
            if(cmp==0){
                return true;
            }else if(cmp>0){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return false;
    }

    public boolean remove(Integer key){
        Node parent = null;
        Node node = root;
        while(root!=null){
            int cmp = key.compareTo(root.val);
            if(cmp==0){
                removeInner(node,parent);
                return true;
            }else if(cmp<0){
                parent = node;
                node = node.left;
            }else{
                parent = node;
                node = node.right;
            }
        }
        return false;
    }
    //node为待删除节点，parent为待删除节点的父节点
    private void removeInner(Node node,Node parent){
        if(node.left==null&&node.right==null){  //代表node是叶子结点
            if(node==root){   //删除的是根节点,且该树只有node节点
                root=null;
            }else if(node==parent.left){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }else if(node.left!=null&&node.right==null){    //代表只有左子树
            if(node==root){
                root = node.left;
            }else if(node==parent.left){
                parent.left = node.left;
            }else{
                parent.right = node.left;
            }
        }else if(node.left==null&&node.right!=null){
            if(node==root){
                root=node.right;
            }else if(parent.left==node){
                parent.left = node.right;
            }else{
                parent.right = node.right;
            }
        }else{
            //使用替换法删除，使用node的左子树中的最大值替换node节点
            //再删除左子树中最大值节点
            Node maxNodeParent = node;
            Node leftMaxNode = node.left;
            while(leftMaxNode.right!=null){
                maxNodeParent = leftMaxNode;
                leftMaxNode = leftMaxNode.right;
            }
            //替换
            node.val = leftMaxNode.val;
            //删除左子树中最大值节点
            if(maxNodeParent==node){
                maxNodeParent.left = leftMaxNode.left;
            }else{
                maxNodeParent.right = leftMaxNode.left;
            }
        }
    }
}
