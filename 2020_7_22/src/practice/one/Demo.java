package practice.one;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
//        int a=2;
//        int b=3;
//        double c = 2.4;
//        double d = 2.5;
//        double e = 3.0;
//        System.out.println(max(a,b));
//        System.out.println(max(c,d));
//        System.out.println(max(c,d,b));
//
//        System.out.println(add(a,b));
//        System.out.println(add(c,d,e));

//        Hannoi hannoi = new Hannoi();
//        hannoi.hannoiStart(4,'A','B','C');

//        for(int i=1;i<=10;i++){
//            System.out.print(fib(i)+" ");
//        }

 //       System.out.println(fun(123));

        //printNum(-45);

        //System.out.println(addN(10));

        //System.out.println(factorial(2));

//        FrogJumpStep frogJumpStep = new FrogJumpStep();
//        int n=3;    //表示台阶数
//        System.out.println("当台阶为:"+n+"，普通蛙有"+frogJumpStep.jumpStep(n)+"种跳法");
//        System.out.println("当台阶为:"+n+"，超级蛙有"+frogJumpStep.superJumpStep(n)+"种跳法");

//        int[] arr = {13,12,10};
//        System.out.println(avg(arr));

//        int[] arr = {1,2,3,4,5};
//        System.out.println(arrSum(arr));

//        int[] arr = {1,2,3};
//        System.out.println(Arrays.toString(arr));
//        transform(arr);
//        System.out.println(Arrays.toString(arr));

//        int[] arr = {1,2,3,4,123,124,1};
//        printArray(arr);

//        int[] arr = creatArr(100);
//        System.out.println(Arrays.toString(arr));

        
    }
    //创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
    public static int[] creatArr(int len){
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i]=i+1;
        }
        return arr;
    }

    //实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
    public static void printArray(int[] arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                System.out.print(arr[i]+"]");
            }else {
                System.out.print(arr[i]+",");
            }
        }
    }

    //实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上.
    // 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
    public static void transform(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]*2;
        }
    }

    //实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
    public static int arrSum(int[] arr){
        int sum=0;
        for(int value:arr){
            sum+=value;
        }
        return sum;
    }

    //实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
    public static double avg(int[] arr){
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum/(arr.length*1.0);
    }

    //递归求 N 的阶乘
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    //递归求 1 + 2 + 3 + ... + 10
    public static int addN(int n){
        if(n==1){
            return 1;
        }
        return n+addN(n-1);
    }

    //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
    public static void printNum(int n){
        if(n<0){
            System.out.print("-"+" ");
            n=-n;
        }
        if(n>9){
            printNum(n/10);
        }
        System.out.print(n%10+" ");
    }

    //写一个递归方法，输入一个非负整数，返回组成它的数字之和
    public static int fun(int n){
        if(n<0){
            return -1;
        }
        if(n<=9){
            return n;
        }
        return (n%10)+fun(n/10);
    }

    //递归求斐波那契数列的第 N 项
    public static int fib(int n){
        if(n<1){
            return -1;
        }
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。
    // 并执行代码，求出结果
    public static int add(int a,int b){
        return a+b;
    }
    public static double add(double a,double b,double c){
        return a+b+c;
    }

    //在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，
    // 还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
    public static int max(int a,int b){
        return (a>b?a:b);
    }
    public static double max(double a,double b){
        return a>b?a:b;
    }
    public static double max(double a,double b,int c){
        double temp = a>b?a:b;
        return temp>c?temp:c;
    }
}
