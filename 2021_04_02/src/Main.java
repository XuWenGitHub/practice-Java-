


public class Main {
    public static void main(String[] args) {

    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //求一个二叉树的深度
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max((depth(root.left)+1),(depth(root.right)+1));
    }





    //有两个有序的数组，要把两个数组中相同的值打印出来
    /*
    分析：
    因为是两个有序的数组，那么我就可以用到双指针
    a1指针指向arr1
    a2指向arr2
    然后判断两个数是否相等？
        相等：打印，两个指针向后移
        不相等：判断哪个值小，哪个值小的指针往后移

     */
    public static void print(int[] arr1,int[] arr2){
        if(arr1==null||arr2==null||arr1.length==0||arr2.length==0){
            return;
        }
        int a1 = 0;
        int a2 = 0;
        while(a1<arr1.length&&a2<arr2.length){
            int num1 = arr1[a1];
            int num2= arr2[a2];
            if(num1==num2){
                System.out.println(num1);
                a1++;
                a2++;
            }else{
                if(num1<num2){
                    a1++;
                }else{
                    a2++;
                }
            }
        }
    }
}
