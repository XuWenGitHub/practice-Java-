package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: Solution
 * @Author: XuWen
 * Date: 2020/10/25 20:55
 * Introduce:
 */
class Solution {
    //计数排序
    public void sortColors(int[] arr) {
        int[] t = new int[3];   //储存0,1,2的个数
        for(int i=0;i<arr.length;i++){
            t[arr[i]]+=1;
        }
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<t[i];j++){
                arr[index++]=i;
            }
        }
    }

    //归并排序
    public void mergeSort(int[] nums,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(nums,left,mid,temp);
            mergeSort(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp);
        }
    }
    public void merge(int[] nums,int left,int mid,int right,int[] temp){
        int l = left;
        int r = mid+1;
        int t=0;
        while(l<=mid&&r<=right){
            if(nums[l]<=nums[r]){
                temp[t++]=nums[l++];
            }else{
                temp[t++]=nums[r++];
            }
        }
        while(l<=mid){
            temp[t++]=nums[l++];
        }
        while(r<=right){
            temp[t++]=nums[r++];
        }
        t=0;
        while(left<=right){
            nums[left++]=temp[t++];
        }
    }
    //快排
    public void quickSort(int[] nums,int left,int right){
        int l=left;
        int r=right;
        int key = nums[(left+right)/2];
        while(l<r){
            while(l<nums.length&&nums[l]<key){
                l++;
            }
            while(r>=0&&nums[r]>key){
                r--;
            }
            if(l>=r){
                break;
            }
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            if(nums[l]==key){
                r--;
            }
            if(nums[r]==key){
                l++;
            }
        }
        if(l==r){
            l++;
            r--;
        }
        if(l<right){
            quickSort(nums,l,right);
        }
        if(left<r){
            quickSort(nums,left,r);
        }
    }
}
