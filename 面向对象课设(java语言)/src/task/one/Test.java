package task.one;

import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String numberList ="1,4,5,2,4,6,7,1,3";
        System.out.println("用字符串保存的逗号分隔的数字序列转成int类型数组为：");
        int arr[]=toArray(numberList);
        System.out.println(Arrays.toString(arr));

        reverse(arr);
        System.out.println("反转后的字符串为：");
        System.out.println(Arrays.toString(arr));

//        System.out.println("希尔排序后的数字序列为：");
//        shellSort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println("快速排序后的数字序列为：");
//        quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));

        System.out.println("归并排序后的数字序列为：");
        int[] temp = new int[arr.length];   //中转数组，在归并排序中，帮忙保存排序好的数组
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));   //这个我懒得写一个打印数组元素的方法，就用了Arrays工具类的toString方法

        System.out.println("序列的平均值为："+average(arr));

        System.out.println("序列离平均值最小的数字为："+arr[nearAverage(arr)]);
        System.out.println("序列离平均值最小的数字在序列中的下标为："+nearAverage(arr));
    }
    //找出最接近平均值的数字，返回其在序列中的位置
    public static int nearAverage(int[] arr){
        float average = average(arr);//数组的平均值
        int index=0;    //和平均数的差值的数在数组中所对应的下标
        float value=Math.abs(arr[0]-average);    //和平均数的差值
        for(int i=1;i<arr.length;i++){
            float f = Math.abs(arr[i]-average);
            if(f<value){
                index=i;
                value=f;
            }
        }
        return index;
    }

    //设计一个方法，来完成序列平均值的计算
    public static float average(int[] arr){
        float result=0;
        for(int i=0;i<arr.length;i++){
            result+=arr[i];
        }
        return result/arr.length;
    }

    //利用栈先进后出，来实现数组的反转
    public static void reverse(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<arr.length;i++){
            stack.push(arr[i]); //因为JDK5的新特性，可以自动拆箱，自动装箱，所有就不用我们来吧int转为Intger类型了
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=stack.pop(); //还是自动拆箱的原理
        }
    }

    //把字符串的数组序列，转到一个数组里
    public static int[] toArray(String s){
        String regex = ",";
        String[] arr = s.split(regex);
        int[] arr2 = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int value=Integer.parseInt(arr[i]);
            arr2[i]=value;
        }
        return arr2;
    }

    /*
    归并排序(分治算法)
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid= (left+right)/2;    //中间索引
            //向左递归
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }
    /**
     * 合并方法
     * @param arr 排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引（也就是左边有序序列的最后一个元素的索引）
     * @param right 右边索引（右边有序序列的最后一个元素的索引）
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        //System.out.println("(:");
        int i=left; //初始化i，左边有序序列的初始索引
        int j = mid+1;  //右边有序序列的初始化索引
        int t = 0;  //指向temp数组的当前索引
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                temp[t] = arr[i];
                t+=1;
                i+=1;
            }else{
                temp[t]=arr[j];
                t+=1;
                j+=1;
            }
        }
        //把有剩余数据的一边的数据一次全部填充到temp
        while(i<=mid){
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while(j<=right){
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t=0;
        int tempLeft = left;
        //第一次合并 templeft=0，right=1//templeft=2，right=3//templeft=1，right=3
        //最后一次 templeft=0, right=7
        while (tempLeft<=right){
            arr[tempLeft] = temp[t];
            t+=1;
            tempLeft+=1;
        }
    }

    /*
    快速排序
     */
    public static void quickSort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int key=arr[(left+right)/2];    //中间值
        //当循环退出后，key左边的元素都比key小，key右边的元素都比key大。
        while(l<r){
            //从左边找到第一个比中间值大或者相等，或者就是中间值本身
            while(arr[l]<key){
                l++;
            }
            //从右往左找到第一个比中间值小或者相等，或者就是中间值本省
            while(arr[r]>key){
                r--;
            }
            //如果l和r相等或者l>r，那么说明中间值的左边都比中间值小，中间值的右边都比中间值大，便可以退出循环
            if(l>=r){
                break;
            }
            //交换
            arr[l]^=arr[r];
            arr[r]^=arr[l];
            arr[l]^=arr[r];
            //判断是否有和中间值key值相同的元素,如果有相同的，l或r不动，另外一个靠拢
            if(arr[l]==key){
                r--;
            }
            if(arr[r]==key){
                l++;
            }
        }
        //当上面循环退出后，我们需要判断两个指针是都指向同一个，如果指向了同一个，那么我们将其错开,防止栈溢出
        //如果两个指针指向同一个，为了下面的递归，我们把其错开
        if(l==r){
            l++;
            r--;
        }
        //左递归
        if(left<r){
            quickSort(arr,left,r);
        }
        //右递归
        if(right>l){
            quickSort(arr,l,right);
        }
    }

    /*
    希尔排序(移位法)：
            把一个数组分组，最开始分成数组长度/2个组，然后对每个组进行直接插入排序
            然后又把数组继续分组，分成数组长度/2/2个组，然后又对每个组进行直接插入排序
            最后分成1个组的时候，就是最后一次直接插入排序,每次分多少个组，也是每个步长
     */
    public static void shellSort(int[] arr){
        //key即是每次移动的步数，也是分多个组
        for(int key=arr.length/2;key>0;key/=2){
            for(int i=key;i<arr.length;i++){
                int temp=arr[i];    //带插入的元素
                int j;
                for(j=i-key;j>=0;j-=key){
                    if(temp<arr[j]){
                        arr[j+key]=arr[j];  //如果temp小于arr[j]，说明arr[j]要往后移
                    }else{
                        break;  //那说明找到了位置
                    }
                }
                arr[j+key]=temp;
            }
        }
    }
}
