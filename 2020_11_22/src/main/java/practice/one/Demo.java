package practice.one;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,40,-1,123,2,-20,10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr){
        createHeap(arr,arr.length);
        for(int i=0;i<arr.length-1;i++){
            int maxVal = arr[0];
            arr[0] = arr[arr.length-1-i];
            arr[arr.length-1-i] = maxVal;
            down(arr,0,arr.length-1-i);
        }
    }
    public static void createHeap(int[] arr,int size){
        int lastIndex = arr.length-1;
        int parent = (lastIndex-1)/2;
        for(int i=parent;i>=0;i--){
            down(arr,i,size);
        }
    }
    public static void down(int[] arr,int index,int size){
        while (true){
            int leftIndex = index*2+1;
            if(leftIndex>=size){
                return;
            }
            int rightIndex = leftIndex+1;
            int maxIndex = leftIndex;
            if(rightIndex<size&&arr[rightIndex]>arr[leftIndex]){
                maxIndex = rightIndex;
            }
            if(arr[index]>=arr[maxIndex]){
                break;
            }
            int t = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = t;
            index = maxIndex;
        }
    }
}
