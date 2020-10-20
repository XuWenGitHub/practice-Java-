package practice.sort;

/**
 * @PackgeName: practice.sort
 * @ClassName: MergeSort
 * @Author: XuWen
 * Date: 2020/10/19 16:18
 * Introduce:
 */
public class MergeSort implements Sort {
    @Override
    public String getName() {
        return "归并排序";
    }

    @Override
    public void sort(int[] arr) {
        mergeSort(arr,0,arr.length-1,new int[arr.length]);
    }
    /*
    归并排序，先分再合的思想
    [left,mid] [mid+1,right] 先照着这个规律一直分下去，然后再把[left,right]合并起来
     */
    private void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            //左递归
            mergeSort(arr,left,mid,temp);
            //右递归
            mergeSort(arr,mid+1,right,temp);
            //当一直分下去，分到一个元素一组的时候，现在开始一直合并，直到数组有序
            merge(arr,left,mid,right,temp);
        }
    }
    //[left,mid] [mid+1,right]两个有序的区间，先合并到temp里面
    //再从temp里导入到arr[left,right]区间
    private void merge(int[] arr,int left,int mid,int right,int[] temp){
        int l = left;   //左边区间的首下标
        int r = mid+1;  //右边区间的首下标
        int t = 0;  //代表中转数组的下标
        //先把两个有序区间往temp里面放，直到其中一个区间全部放了进去
        while(l<=mid&&r<=right){
            if(arr[l]<arr[r]){
                temp[t] = arr[l];
                l++;
            }else{
                temp[t] = arr[r];
                r++;
            }
            t++;
        }
        //再把两个区间中剩余的往里面放进temp即可，就可以保证temp中是有的
        while(l<=mid){
            temp[t++] = arr[l++];
        }
        while (r<=right){
            temp[t++]=arr[r++];
        }
        //现在把中转数组中合并后有序的区间全部转移到arr[left,right]区间里面
        t = 0;
        while(left<=right){
            arr[left++] = temp[t++];
        }
    }
}
