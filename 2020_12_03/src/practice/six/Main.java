package practice.six;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);

        }
//        arr = new int[]{1,2,3,4,5,6};
//        arr = new int[]{6,5,4,3,2,1};
        //quickSort(arr, 0, arr.length - 1);
        mergeSort(arr,0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快排
     * 每次拿出一个数，将这个数组中，比这个数小的放左边，
     * 比这个数大的放右边，然后返回该数的下标。
     * 然后递归处理左边，递归处理右边
     * 当区间==1说明有序
     */
    public static void quickSort(int[] arr, int left, int right) {
        int size = right - left + 1;    //算出区间中元素的个数
        if (size <= 1) {    //当个数小于等于1，都已经有序
            return;
        }
        //[left,right]
        if (left != right) {
            //进行partition，然后返回以返回的partition进行分割,递归处理
            int partition = partitionSlowFast(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    //从左往右找比key大的，从右往左找比key小的
    //然后交换，l<r即可
    //对区间[left,right]进行partition，分割成两部分
    public static int partition(int[] arr, int left, int right) {
        int key = arr[left];    //拿出区间[left,right]区间第一个数，进行partition
        //l!=left+1,因为就算拿arr[left]，进行partition,但是如果[left,right]刚好有两个元素
        //如果l=left+1，那么while循环里面，直接跳出循环，直接交换，是有可能出错的
        int l = left; //l指针
        int r = right; //r指针
        //要先让r先走，因为如果让l先走，最后l==r的时候，与key值交换，就需要跟情况判断
        while (l < r) {
            while (l != r && arr[r] >= key) {
                r--;
            }
            while (l != r && arr[l] <= key) {
                l++;
            }
            if (l == r) {
                break;
            }
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
        }
        arr[left] = arr[l];
        arr[l] = key;
        return l;
    }

    //挖坑法
    //先l位置挖一个坑，然后r往l靠拢，找比key小的，找到然后去填坑
    //然后l往r靠拢，找比key大的，找到然后去填坑
    //直到l==r，最后再把key填进去，就ok了
    public static int partitionWaKeng(int[] arr, int left, int right) {
        int l = left;   //左边指针
        int r = right;  //右边指针
        int key = arr[l];    //l位置挖一个坑
        while (l != r) {
            //因为挖的是最左边第一个，第一个坑再left位置
            //所有r先往l方向走
            while (r != l && arr[r] >= key) {
                r--;
            }
            arr[l] = arr[r];    //填坑，下一次l移动去填坑
            //r填在了l位置的坑，r位置就有个坑
            //所以就需要l往r方向走，去找元素填坑
            while (l != r && arr[l] <= key) {
                l++;
            }
            arr[r] = arr[l];    //填坑，下一次r移动去填坑

        }
        //填坑
        arr[l] = key;
        return l;
    }

    //快慢指针
    //保证慢指针的左边都小于等于key，即可
    //等快指针走到right+1位置，那么把key元素的位置（一般也就是第一个位置）
    //和慢指针前面元素交换即可
    public static int partitionSlowFast(int[] arr,int left,int right){
        int key = arr[left];
        int slow = left+1;   //表示l左边全是小于等于key的
        //r去判断，如果小于等于key，那么l和r交换对应的数
        //然后l和r一起往后走一步
        //如果大于key，那么r往后走
        int fast = left+1;
        while (fast!=right+1){
            if(arr[fast]<=key){
                int t = arr[slow];
                arr[slow] = arr[fast];
                arr[fast] = t;
                slow++;
            }
            fast++;
        }
        arr[left] = arr[slow-1];
        arr[slow-1] = key;
        return slow-1;
    }

    //归并排序
    //把大区间不断的划分为小区间，直到只有一个区间里元素只有一个，那么说明就是有序的，那么再合并
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left==right){    //低估结束条件
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arr,left,mid,temp);
        mergeSort(arr,mid+1,right,temp);
        merge(arr,left,mid,right,temp);
    }

    //合并[left,mid] [mid+1,right]区间
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l1 = left;
        int l2 = mid+1;
        int t=0;    //temp的下标,temp中转数组
        while(l1<=mid&&l2<=right){
            if(arr[l1]<=arr[l2]){
                temp[t++] = arr[l1++];
            }else {
                temp[t++] = arr[l2++];
            }
        }
        //再把剩余的添加进中转数组
        while(l1<=mid){
            temp[t++] = arr[l1++];
        }
        while (l2<=right){
            temp[t++] = arr[l2++];
        }
        //最后再把temp中有序的元素，填充到arr的[left,right]区间里面
        t = 0;
        while(left<=right){
            arr[left++] = temp[t++];
        }
    }


}
