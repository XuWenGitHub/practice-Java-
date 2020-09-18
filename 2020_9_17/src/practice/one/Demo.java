package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/17 19:22
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
    public int[] printNumbers(int n) {
        int len = (int)Math.pow(10,n)-1;
        int[] arr = new int[len];
        for(int i=1;i<=len;i++){
            arr[i-1]=i;
        }
        return arr;
    }

    // you need to treat n as an unsigned value
    //统计一个整数中二进制中1的个数
    public int hammingWeight(int n) {
        int sum=0;
        while(n!=0){
            if((n&1)==1){
                sum++;
            }
            n>>>=1;
        }
        return sum;
    }

    //青蛙跳台阶
    public int numWays(int n) {
        return numWays(new int[n+1],n);
    }
    public int numWays(int[] arr,int n){
        if(n==0){
            return 1%1000000007;
        }
        if(n==1){
            return 1%1000000007;
        }
        if(n==2){
            return 2%1000000007;
        }
        if(arr[n]>0){
            return arr[n]%1000000007;
        }
        arr[n] = (numWays(arr,n-1)+numWays(arr,n-2))%1000000007;
        return (numWays(arr,n-1)+numWays(arr,n-2))%1000000007;
    }

    //二分查找
    /*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数 组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
    (1)当arr[mid]<arr[right]  :  right=mid;
    (2)当arr[mid]>arr[right]  :  left=mid;
    (3)当arr[mid]==arr[right]  :  right--;
    当left==right,就返回numbers[left]
    */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while(left!=right){
            int mid = (left+right)/2;
            if(numbers[mid]<numbers[right]){ //说明后面部分没有被旋转，舍弃后面
                right = mid;
            }else if(numbers[mid]>numbers[right]){   //说明最小值再后面一部分,舍弃前面
                left = mid+1;
            }else{   //如果相等判断不了
                right--;
            }
        }
        return numbers[left];
    }
}
