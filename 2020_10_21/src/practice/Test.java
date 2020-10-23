package practice;

import java.util.Arrays;

/**
 * @PackgeName: practice
 * @ClassName: Test
 * @Author: XuWen
 * Date: 2020/10/20 18:55
 * Introduce:
 */
public class Test {
    int a;
    public static void main(String[] args) {
        int[] arr = {3,9,5,3,3,8,3,7,6};
        quickSort(arr,0,arr.length-1);
        //mergeSort(arr,0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));

        long[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        long[] arr3 = {1,3,5,7,9,11,13};
        long[] arr4 = {2,4,6,8,10,12,14};
        oddEvenChange(arr2);
        System.out.println(Arrays.toString(arr2));
        oddEvenChange(arr3);
        System.out.println(Arrays.toString(arr3));
        oddEvenChange(arr4);
        System.out.println(Arrays.toString(arr4));

        long a = 5;
        long b = 5;
        a^=b;
        b^=a;
        a^=b;
        System.out.println(a+" "+b);
    }
    //temp为中转数组，递归后，合并用
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        //每次分，分到[left,right]区间只有一个元素，那么这个区间肯定有序，先分再合
        if(left<right){
            int mid = (left+right)/2;
            //左递归和右递归,把数组一直照着[left,mid] [mid+1,right]一直划分
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            //再把两个有序的区间合并，合并[left,mid]和[mid+1,right]区间
            //先合并到中转数组temp中，再把合并后的放在中转数组的temp，去放回arr的[left,right]位置
            merge(arr,left,mid,right,temp);
        }
    }
    //合并数组中有序区间[left,mid]和[mid+1,right]合并成整体有序的，再存入arr[left,right]区间里,
    //temp为中转数组,先往temp里合并，最后再导入到arr的[left,right]区间里
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int l =left;    //[left,mid]区间的下标
        int r = mid+1;  //[mid+1,right]区间的下标
        int t=0;    //中转数组的下标
        //先把两个区间中其中一个全装入temp
        while (l<=mid&&r<=right){
            if(arr[l]<=arr[r]){ //加上=号，保证稳定性，就是两个一样大的，取左边的
                temp[t] = arr[l];
                l++;
            }else{
                temp[t] = arr[r];
                r++;
            }
            t++;
        }
        //现在把两个区间中剩余的那个区间全转到temp里面
        while (l<=mid){
            temp[t++] = arr[l++];
        }
        while (r<=right){
            temp[t++] = arr[r++];
        }
        //最后把temp里所有转到arr的[left,right]区间里
        t = 0;
        while (left<=right){
            arr[left++] = temp[t++];
        }
    }
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int key = arr[(l+r)/2];
        while (l<r){
            while(l<arr.length&&arr[l]<key){
                l++;
            }
            while (r>=0&&arr[r]>key){
                r--;
            }
            if(l>=r){
                break;
            }
            arr[l]^=arr[r];
            arr[r]^=arr[l];
            arr[l]^=arr[r];
            //解决key这个值的数有多个，那么l指向一个，r指向一个，就会两个无限交换，死循环
            if(arr[l]==key){
                r--;
            }
            if(arr[r]==key){
                l++;
            }
        }
        //将l和r错开，因为中间这个已经有序的
        if(l==r){
            l++;
            r--;
        }
        //然后去递归处理[left,r] [l,right] 这个区间
        if(left<r){
            quickSort(arr,left,r);
        }
        if(l<right){
            quickSort(arr,l,right);
        }
    }
    public static void oddEvenChange(long[] arr){
        int left = 0;
        int right = arr.length-1;
        while (left<right){
            //从左往右找偶数
            while(left<arr.length&&arr[left]%2==1){
                left++;
            }
            //从右往左找奇数
            while (right>=0&&arr[right]%2==0){
                right--;
            }
            if(left>=right){
                break;
            }
            arr[left]^=arr[right];
            arr[right]^=arr[left];
            arr[left]^=arr[right];
        }
    }
}
