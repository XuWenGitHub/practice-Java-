package practice.one;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2,-1,3,7,10,5,4,-10};
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        //先将一个数组构成大顶堆
        for(int i=arr.length-1;i>=0;i--){
            downAdjust(arr,arr.length,i);
        }
        //将最大的放到最后面一个元素交换位置
        int temp = arr[0];
        arr[0] = arr[arr.length-1];
        arr[arr.length-1] = temp;
        for(int i=1;i<arr.length;i++){
            //然后交换过来后，只有头结点不满足大顶推，然后向下调整
            downAdjust(arr,arr.length-i,0);
            //然后交换
            temp = arr[0];
            arr[0] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    //arr看成二叉树，len当前数组的长度，index：需要调整的位置
    public static void downAdjust(int[] arr,int len,int index){
        while (true){
            int leftIndex = index*2+1;  //左子树的下标
            if(leftIndex>=len){  //代表没有左子树，那么一定没有右子树，表示不需要向下调整
                break;
            }
            int maxIndex = leftIndex;   //左子树和右子树，最大的值
            if(leftIndex+1<len&&arr[leftIndex+1]>arr[leftIndex]){
                //如果右子树存在，并且右子树>左子树的值，那么最大值的下标将是右子树
                maxIndex = leftIndex+1;
            }
            if(arr[index]>=arr[maxIndex]){   //表示不需要往下调整了
                break;
            }
            //表示需要调整，index位置的节点和最大子节点，交换位置
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
            //继续将maxIndex往下调整
            index = maxIndex;
        }
    }
}
