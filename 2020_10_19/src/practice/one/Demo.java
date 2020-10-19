package practice.one;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/18 21:14
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
    public static int[] getArr(){
        Random random = new Random(43433412);
        int[] res = new int[10];
        for(int i=0;i<res.length;i++){
            res[i] = random.nextInt(100);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        root.right = node2;
        node2.left = node3;
        //int[] res =
        int[] res = getArr();
        System.out.println(Arrays.toString(res));
        //quickSort(res,0,res.length-1);
        mergeSort(res,0,res.length-1,new int[res.length]);
        System.out.println(Arrays.toString(res));
    }
    //归并排序
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            //把数组一直划分为[left,mid] [mid+1,right]两部分，一直拆分到一个元素一组的时候
            int mid = (left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            //再把分开的两个有序区间合并
            merge(arr, left, mid, right, temp);
        }
    }
    //[left,mid] [mid+1,right]合并这两部分，temp为中转数组
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int leftIndex = left;   //这表示左边区间的头
        int rightIndex = mid+1; //这表示右边区间的头
        int tempIndex = 0;  //这表示中转数组的下标
        while (leftIndex<=mid&&rightIndex<=right){
            if(arr[leftIndex]<arr[rightIndex]){
                temp[tempIndex] = arr[leftIndex];
                leftIndex++;
            }else{
                temp[tempIndex] = arr[rightIndex];
                rightIndex++;
            }
            tempIndex++;
        }
        //再把剩余的添加到temp中
        while(leftIndex<=mid){
            temp[tempIndex++] = arr[leftIndex++];
        }
        while(rightIndex<=right){
            temp[tempIndex++]=arr[rightIndex++];
        }
        //最后再把temp所有转到[left,right]这部分
        tempIndex = 0;
        while(left<=right){
            arr[left++] = temp[tempIndex++];
        }
    }
    public static void quickSort(int[] arr,int left,int right){
        int l=left;
        int r = right;
        int key = arr[(l+r)/2];
        while(l<r){
            //从左往右找第一个比key大或者相等的，最坏情况就是自己
            while(l<arr.length&&arr[l]<key){
                l++;
            }
            //从右往左找第一个比key小或者相等的，最坏情况也就找到key
            while(r>=0&&arr[r]>key){
                r--;
            }
            if(l>=r){   //如果l和r指向同一个或者l和r错位了，说明已经完成目前目标
                break;
            }
            //走到这里如果没有退出，两个元素交换
            arr[l]^=arr[r];
            arr[r]^=arr[l];
            arr[l]^=arr[r];
            //判断l下标和r下标的元素是否和key相等，如果相等，另一边向其靠拢，这主要解决数组中有和key相等的元素
            if(arr[l]==key){
                r--;
            }
            if(arr[r]==key){
                l++;
            }
        }
        //判断如果l和r指向同一个了，将其错开
        if(l==r){
            l++;
            r--;
        }
        if(left<r){
            quickSort(arr,left,r);
        }
        if(l<right){
            quickSort(arr,l,right);
        }
    }

}
