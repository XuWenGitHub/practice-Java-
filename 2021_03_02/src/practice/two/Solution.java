package practice.two;

class Solution {
    int res = 0;

    //利用分治思想
    //每次合并的时候，去确定逆序对的个数有多少个
    //统计在res中，返回
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return res;
    }

    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归
            mergeSort(arr, left, mid, temp);
            //向右递归
            mergeSort(arr, mid + 1, right, temp);
            //合并，并算出逆序对
            int num = merge(arr, left, mid, right, temp);
            res += num;
        }
    }

    //合并[left,mid]区间和[mid+1,right]区间，返回逆序对的个数
    public int merge(int[] arr, int left, int mid, int right, int[] temp) {
        int inverseOrder = 0;   //合并中逆序对的个数
        int l1 = left;
        int l2 = mid + 1;
        int t = 0;
        while (l1 <= mid && l2 <= right) {
            if (arr[l1] <= arr[l2]) {
                temp[t++] = arr[l1++];
            } else {
                inverseOrder += (mid - l1 + 1);
                temp[t++] = arr[l2++];
            }
        }
        while (l1 <= mid) {
            temp[t++] = arr[l1++];
        }
        while (l2 <= right) {
            temp[t++] = arr[l2++];
        }
        t = 0;
        for (int i = left; i <= right; i++) {
            arr[i] = temp[t++];
        }
        return inverseOrder;
    }
}