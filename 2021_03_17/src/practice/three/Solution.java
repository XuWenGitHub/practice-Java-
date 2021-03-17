package practice.three;

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1,new int[nums.length]);
    }
    public int mergeSort(int[] nums,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            int l = mergeSort(nums,left,mid,temp);
            int r = mergeSort(nums,mid+1,right,temp);
            return l+r+merge(nums,left,mid,right,temp);
        }
        return 0;
    }
    public int merge(int[] nums,int left,int mid,int right,int[] temp){
        int res = 0;
        int l1 = left;
        int l2 = mid+1;
        int t = 0;
        while(l1<=mid&&l2<=right){
            if(nums[l1]<=nums[l2]){
                temp[t++] = nums[l1++];
            }else{
                res+=(mid-l1+1);
                temp[t++] = nums[l2++];
            }
        }
        while(l1<=mid){
            temp[t++] = nums[l1++];
        }
        while(l2<=right){
            temp[t++] = nums[l2++];
        }
        t = 0;
        for(int i=left;i<=right;i++){
            nums[i] = temp[t++];
        }
        return res;
    }
}
