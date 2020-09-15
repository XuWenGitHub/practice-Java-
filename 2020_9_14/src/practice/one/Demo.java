package practice.one;
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    //构造器
    public TreeNode(int val){
        this.val = val;
    }
}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/14 13:43
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
    统计一个数字在排序数组中出现的次数
    先写一个查找target的方法，找到下标，然后左右蔓延,如果没有找到直接返回-1
    */
    public int search(int[] nums, int target) {
        int index = searchOneNum(nums,target);
        if(index==-1){
            return 0;
        }
        int sum = 1;
        int left = index-1;
        while(left>=0&&nums[left]==target){
            left--;
            sum++;
        }
        int right = index+1;
        while(right<nums.length&&nums[right]==target){
            right++;
            sum++;
        }
        return sum;
    }
    public int searchOneNum(int[] nums,int target){
        //i表示左边，j表示右边
        for(int i=0,j=nums.length-1;i<=j;){
            int mid = (i+j)/2;
            if(nums[mid]<target){
                i=mid+1;
            }else if(nums[mid]>target){
                j=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }


    //判断一个树是不是平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = root.left != null ? height(root.left) : 0;
        int right = root.right != null ? height(root.right) : 0;
        return (Math.abs(left - right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //判断一个树的高度
    public int height(TreeNode root) {
        return Math.max((root.left == null ? 0 : height(root.left)), (root.right == null ? 0 : height(root.right))) + 1;
    }


    /*
    一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    输入: [0,1,3]
    输出: 2
    输入: [0,1,2,3,4,5,6,7,9]
    输出: 8
    */
    //折半查找，发现，每个数字的值，都是其下标，如果不是，则找到第一个符合的
    public int missingNumber(int[] nums) {
        if(nums[0]!=0){
            return 0;
        }
        //查找缺失的数字
        for(int i=0,j=nums.length-1;i<=j;){
            int mid = (i+j)/2;
            if(nums[mid]==mid){ //如果中间数是正确的，那么前面都没有错，然后i变成mid后面这个
                i=mid+1;
            }else if(nums[mid]!=mid){   //如果中间数不是正确的
                if(nums[mid-1]==mid-1){ //那么判断中间数前面的一个正确不
                    return mid; //如果前面这个数字是正确的，那么说明mid就是缺失的数字
                }else{
                    j=mid-1;    //如果前面这个数字也是错误的，那么j变成mid-1，然后继续循环
                }
            }
        }
        //循环退出后，如果还没有返回，说明数组正确，数组中每一个元素，都和其下标是相等的
        //如果没有缺失，那么说明，数组OK，就差nums.length，例如[0,1]差2 [0]差1
        return nums.length;
    }

    //给定一颗二叉搜索树，请找出其中第K大的节点
    class Solution {
        int sum=0;  //就是K，来表示第几大的节点
        int res=0;  //存入最后的节点
        public int kthLargest(TreeNode root, int k) {
            this.sum = k;   //给sum初始化
            infixOrderDesc(root);   //逆序中序遍历，然后找到第K大的节点
            return res;
        }

        public void infixOrderDesc(TreeNode root){
            if(root==null){
                return;
            }
            infixOrderDesc(root.right); //先递归找到最大的
            if((--sum)==0){ //sum先--，判断是否为0，如果为0了，那么就说明是第k大的节点了
                this.res = root.val;    //给res赋值
                return; //找到后，省略不必要的递归
            }
            infixOrderDesc(root.left);
        }
    }

    //求一个二叉树的深度,就是一个二叉树的高度
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max((root.left==null?0:maxDepth(root.left)),(root.right==null?0:maxDepth(root.right)))+1;
    }

    //一个数组中，找到和为s的两个数字
    public int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum>target){
                right--;
            }else if(sum<target){
                left++;
            }else{
                return new int[]{nums[left],nums[right]};
            }
        }
        return null;
    }


}
