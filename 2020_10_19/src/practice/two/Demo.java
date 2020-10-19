package practice.two;

import java.util.Arrays;
import java.util.Random;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/19 10:19
 * Introduce:
 */
public class Demo {
    public static int[] getArr(){
        Random random = new Random(123112);
        int[] res = new int[10];
        for(int i=0;i<res.length;i++){
            res[i] = random.nextInt(100);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = getArr();
        int[] arr2 = {9,8,7,6,5,4,3,2,1};
        int[] arr3 = {1,1,1,1,2,1,1,1,1,1,1};
        System.out.println(Arrays.toString(arr));
        //quickSort(arr3,0,arr3.length-1);
        mergeSort(arr,0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));

    }
    //希尔排序  分组插入排序
    public static void shellSort(int[] arr){
        int group = arr.length/2;
        while(group>0){
            groupInsertSort(arr,group);
            group/=2;
        }
    }
    //分组插入
    public static void groupInsertSort(int[] arr,int group){
        for(int i=group;i<arr.length;i++){
            int temp = arr[i];  //取出待插入元素
            int j;
            for(j = i-group;j>=0;j-=group){
                if(arr[j]<=temp){
                    break;
                }else{
                    arr[j+group] = arr[j];
                }
            }
            arr[j+group] = temp;
        }
    }

    //堆排序
    public static void heapSort(int[] arr){
        create(arr,arr.length);
        for(int i=0;i<arr.length-1;i++){
            int maxVal = arr[0];
            arr[0]=arr[arr.length-1-i];
            arr[arr.length-1-i] = maxVal;
            adjustDown(arr,arr.length-1-i,0);
        }
    }
    public static void create(int[] arr,int size){
        int lastIndexParent = (size-2)/2;
        for(int i=lastIndexParent;i>=0;i--){
            adjustDown(arr,size,i);
        }
    }
    public static void adjustDown(int[] arr,int size,int index){
        while (true){
            int leftIndex = (index*2)+1;
            if(leftIndex>=size){
                break;
            }
            int maxIndex = leftIndex;
            if(leftIndex+1<size&&arr[leftIndex+1]>arr[leftIndex]){
                maxIndex = leftIndex+1;
            }
            if(arr[maxIndex]<=arr[index]){
                break;
            }
            arr[index]^=arr[maxIndex];
            arr[maxIndex]^=arr[index];
            arr[index]^=arr[maxIndex];
            index = maxIndex;
        }
    }


    //快排
    //找到中间值，然后排序，让左边的都比中间值小，右边的都比中间值大
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int key = arr[(l+r)/2];
        while(l<r){
            //先从左边找到比mid大或者相等的（最坏的情况就是找到mid)
            while (l<arr.length&&arr[l]<key){
                l++;
            }
            //再从右边找到比mid小或者相等的（最坏的情况就是好到mid）
            while(r>=0&&arr[r]>key){
                r--;
            }
            //判断L是否还小于R,如果L不小于R或者等于R，那就退出循环，说明中间值左右都符合规则
            if(l>=r){
                break;
            }
            //如果还没有退出，就两者交换
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            //防止如果有和key值相同的元素，就会两者一直不停的交换交换，死循环，这样就避免了
            if(arr[l]==key){
                r--;
            }
            if(arr[r]==key){
                l++;
            }
        }
        //走到这里，l和r可能都指向key，那说明key这个数已经有序了，然后我们把l和r错开，然后递归
        //如果走到这里，l和r没有指向key，那么不用错开，直接递归即可
        if(l==r){
            l++;
            r--;
        }
        //递归去执行左边和右边
        if(left<r){
            quickSort(arr,left,r);
        }
        if(l<right){
            quickSort(arr,l,right);
        }
    }
    //求n的阶乘(递归)
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;   //中间索引
            //向左递归
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1,right,temp);
            //把数组一直分为[left,mid] 和 [mid+1,right]两部分
            //合并，合并数组两部分，再填回数组,需要用到temp中转数组
            merge(arr,left,mid,right,temp);
        }
    }
    //把数组一直分为[left,mid] 和 [mid+1,right]两部分合并
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int l = left;   //代表左边数组的指针
        int r = mid+1;  //代表右边数组的指针
        //先把两个有序的数组合并到temp中转数组中
        int t = 0;  //中转数组的下标
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
        //当上面循环退出，有一边就已经添加结束，现在把没有添加完的，添加完
        while (r<=right){
            temp[t] = arr[r];
            t++;
            r++;
        }
        while(l<=mid){
            temp[t] = arr[l];
            l++;
            t++;
        }
        //现在把temp中合并后的转到arr里面
        t = 0;
        while(left<=right){
            arr[left] = temp[t];
            t++;
            left++;
        }
    }
}
