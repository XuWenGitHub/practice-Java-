import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        int[] arr={1,2,3,4,5,6,7,8,1,2,3,4,6,7,8,1};
//        System.out.println("单身狗:"+findSingleDog(arr));
//        System.out.print(fib(5)+" ");

//        System.out.println(Arrays.toString(arr));
//        oddBeforeEven(arr);
//        System.out.println(Arrays.toString(arr));

        //System.out.println("5阶乘和="+factAdd(5));

        System.out.println(findMax(12,0,3));
    }

    //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
    //​ 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
    public static int findMax(int a,int b,int c){
        //方法重载：同一个类中，方法名相同，参数个数或者参数类型或者不同的参数类型的顺序不同即可.
        return findMax(findMax(a,b),c);
    }
    public static int findMax(int a,int b){
        return (a>b)?a:b;
    }


    //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
    public static void oddBeforeEven(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            //从左往右找第一个偶数
            while(left<arr.length&&arr[left]%2==1){
                left++;
            }
            //从右往左找第一个奇数
            while(right>=0&&arr[right]%2==0){
                right--;
            }
            //再判断left是否小于right,不然有可能已经错位了
            if(left>=right){
                break;
            }
            //如果上面没有break，那么两者交换
            arr[left]^=arr[right];
            arr[right]^=arr[left];
            arr[left]^=arr[right];
        }
    }

    //求1！+2！+3！+4！+........+n!的和
    public static int factAdd(int n){
        int result=0;
        for(int i=1;i<=n;i++){
            //result+=factorial(i);
            result+=factorial2(i);
        }
        return result;
    }

    //求n的阶乘非递归
    public static int factorial(int n){
        int fac = 1;
        for(int i=1;i<=n;i++){
            fac*=i;
        }
        return fac;
    }

    //求n的阶乘递归
    public static int factorial2(int n){
        if(n==1){
            return 1;
        }
        return n*(factorial2(n-1));
    }

    //求斐波那契数列的第n项。(迭代实现)
    /**
     * 求第n项斐波那契数
     * @param n 从1开始
     * @return  第n项斐波那契数
     */
    public static int fib(int n){
        if(n==1||n==2){
            return 1;
        }
        int one=1;
        int two=1;
        int value=0;
        for(int i=3;i<=n;i++){
            value=one+two;
            one=two;
            two=value;
        }
        return value;
    }
    //有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
    public static int findSingleDog(int[] arr){
        int singleDog=arr[0];
        for(int i=1;i<arr.length;i++){
            //让其整体异或，就能找到单身狗，两个相同的数异或便变成了0，任何数异或0，是自身
            singleDog^=arr[i];
        }
        return singleDog;
    }
}
