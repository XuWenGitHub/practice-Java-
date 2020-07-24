import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
//        int[] arr={1,2,-1,0,23,51,123,-23,-10};
//        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        reserve(arr,0,arr.length-1);
//        //quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));

//        int[][] arr=new int[2][3];
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);

//        int[] arr = {1,2,3,4,5,6,7};
//        //reservePrintf(arr,0);
//        System.out.println(Arrays.toString(arr));
//        reserve(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));

//        String s=null;
//        System.out.println("s="+s);
    }
    //递归逆序打印数组(没有改变数组内部元素的顺序)
    public static void reservePrintf(int[] arr,int i){
        if(i<arr.length-1){
            reservePrintf(arr,i+1);
        }
        System.out.print(arr[i]+" ");
    }
    //递归让数组逆序(改变了数组内部元素的顺序)
    public static void reserve(int[] arr,int left,int right){
        if((left+1)<(right-1)){
            reserve(arr,(left+1),(right-1));
        }
        arr[left]^=arr[right];
        arr[right]^=arr[left];
        arr[left]^=arr[right];
    }
    //数组逆序(改变了数组内部元素的顺序)
    public static void reserve(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            arr[left]^=arr[right];
            arr[right]^=arr[left];
            arr[left]^=arr[right];
            left++;
            right--;
        }
    }
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    arr[i]^=arr[j];
                    arr[j]^=arr[i];
                    arr[i]^=arr[j];
                }
            }
        }
    }
    public static void bubbleSort(int[] arr){
        boolean flag=false;
        for(int i=0;i<arr.length-1;i++){
            flag=false; //!!!
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    arr[j]^=arr[j+1];
                    arr[j+1]^=arr[j];
                    arr[j]^=arr[j+1];
                }

            }
            if(!flag){
                break;
            }
        }
    }
    public static void quickSort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int key=arr[(left+right)/2];
        while(l<r){
            while(arr[l]<key){
                l++;
            }
            while (arr[r]>key){
                r--;
            }
            if(l>=r){
                break;
            }
            arr[l]^=arr[r];
            arr[r]^=arr[l];
            arr[l]^=arr[r];
            if(arr[l]==key){
                r--;
            }
            if(arr[r]==key){
                l++;
            }
        }
        if(l==r){
            l++;
            r--;
        }
        if(left<r){
            quickSort(arr,left,r);
        }
        if(right>l){
            quickSort(arr,l,right);
        }
    }
    public static boolean isSorted(int[] arr){
        if(arr==null||arr.length==0){
            return false;
        }
        boolean flag=true;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
