package practice.one;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
//        //System.out.println(myString(arr));
//        System.out.println(Arrays.toString(arr));
//        int[] arr2 = arr.clone();
//        arr[1]=0;
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr2));

//        int[] arr = {1,2,3,4,5,7};
////        System.out.println(maxSearch(arr));
////        System.out.println(avg(arr));
//        System.out.println(binarySearch(arr,3));

        int[] arr = {1,4,123,4,21,4,2,1,-1,-12};
        //System.out.println(Arrays.toString(arr));
        //System.out.println(isOrder(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        //System.out.println(isOrder(arr));
        System.out.println(binarySearch(arr,4));
    }
    //实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
    public static int[] myCopyOf(int[] arr){
        int[] copyArr = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            copyArr[i]=arr[i];
        }
        return copyArr;
    }

    //二分查找
    public static int binarySearch(int[] arr,int key){
        if(arr==null){
            return -2;
        }
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>key){
                right=mid-1;
            }else if(arr[mid]<key){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    //给定一个整型数组, 判定数组是否有序（递增）
    public static boolean isOrder(int[] arr){
        boolean flag=true;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                flag=false;
                break;
            }
        }
        return flag;
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]^=arr[j+1];
                    arr[j+1]^=arr[j];
                    arr[j]^=arr[j+1];
                }
            }
        }
    }

    //找数组中的最大值
    public static int maxSearch(int[] arr){
        if(arr==null){
            return -1;
        }
        if((arr.length-1)==-1){
            return -1;
        }
        int value=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>value){
                value=arr[i];
            }
        }
        return value;
    }
    //求数组中元素的平均值
    public static double avg(int[] arr){
        if(arr==null){
            return -1;
        }
        if((arr.length-1)==-1){
            return 0;
        }
        double result=arr[0];
        for(int i=1;i<arr.length;i++){
            result+=arr[i];
        }
        return result/(arr.length);
    }

    //数组拷贝
    public static int[] myArraysCopyOf(int[] src,int newlength){
        int[] newArr = new int[newlength];
        for(int i=0;i<newlength;i++){
            newArr[i]=src[i];
        }
        return newArr;
    }

    //模拟toString方法
    public static String myString(int[] array){
        if(array==null){
            return "null";
        }
        if((array.length-1)==-1){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<array.length;i++){
            if(i==array.length-1){
                sb.append(array[i]);
            }else {
                sb.append(array[i]).append(",").append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
