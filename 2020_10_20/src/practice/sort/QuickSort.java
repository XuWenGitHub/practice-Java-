package practice.sort;

/**
 * @PackgeName: practice.sort
 * @ClassName: QuickSort
 * @Author: XuWen
 * Date: 2020/10/19 16:42
 * Introduce:
 */
public class QuickSort implements Sort {
    @Override
    public String getName() {
        return "快速排序";
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }
    public void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int key = arr[(l+r)/2]; //中间值
        while (l<r){
            //从左往右找，找到第一个比中间值大或者相等的数的下标,最坏情况就是找到中间值下标
            while(l<arr.length&&arr[l]<key){
                l++;
            }
            //从右往左找，找到第一个比中间值小或者相等的数的下标，最坏情况就是找到中间值下标
            while(r>=0&&arr[r]>key){
                r--;
            }
            //走到这里，先判断l>=r，那说明已经符合key左边都比key小，key右边都比key大
            if(l>=r){
                break;
            }
            //如果没有退出的话，两个数交换位置
            int t=arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            //现在再判断l指针和r指针指向的是否和key值相同，如果相同，向其靠拢
            //这样防止有和key值相同的数多个，然后l<r,但l和r都指向了和key值相等的数，就会死循环
            if(arr[l]==key){
                r--;
            }
            if(arr[r]==key){
                l++;
            }
        }
        //当退出循环后，因为要向左递归和右递归，[left,r] [l,right]这两个区间递归
        //所有l和r不能指向同一个，如果指向同一个就错开
        if(l==r){
            l++;
            r--;
        }
        //递归处理左边和右边
        if(left<r){
            quickSort(arr,left,r);
        }
        if(l<right){
            quickSort(arr,l,right);
        }
    }
}
