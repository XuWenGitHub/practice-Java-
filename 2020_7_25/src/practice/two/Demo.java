package practice.two;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = {6,5,4,3,2,1};
//        System.out.println(Arrays.toString(arr));
//        changeArr(arr);
//        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println("--------------------");
        swapArr(arr,arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    //给定两个整型数组, 交换两个数组的内容.
    //先自己定义规则，如果两个数组不一样长，以长度小的为主，只交换数组长度小的那么多元素
    public static void swapArr(int[] arr1,int[] arr2){
        int min = Math.min(arr1.length, arr2.length);
        for(int i=0;i<min;i++){
            arr1[i]^=arr2[i];
            arr2[i]^=arr1[i];
            arr1[i]^=arr2[i];
        }
    }

    //给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
    public static void changeArr(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            //left先从左往右找到第一个奇数
            while(arr[left]%2==0){
                left++;
            }
            //right先从右往左找到第一个偶数
            while(arr[right]%2==1){
                right--;
            }
            if(left>=right){
                break;
            }
            //交换
            arr[left]^=arr[right];
            arr[right]^=arr[left];
            arr[left]^=arr[right];
        }
    }
}
