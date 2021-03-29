import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        ReentrantLock reentrantLock = new ReentrantLock();
    }
    //对[left,right]区间进行快排
    public static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int patton = patton(arr, left,right);    //当前位置元素，已经有序
            quickSort(arr,left,patton-1);
            quickSort(arr,patton+1,right);
        }
    }
    //挖坑法处理
    public static int patton(int[] arr,int left,int right){
        int key = arr[left];
        int l = left;
        int r = right;
        while(l!=r){
            while(l!=r&&r>=0&&arr[r]>=key){
                r--;
            }
            if(l==r||r<0){
                break;
            }
            arr[l] = arr[r];
            while (l!=r&&l<=right&&arr[l]<=key){
                l++;
            }
            if(l==r||l>right){
                break;
            }
            arr[r] =arr[l];
        }
        arr[l] = key;
        return l;
    }

}
