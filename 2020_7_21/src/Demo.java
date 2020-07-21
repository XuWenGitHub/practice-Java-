import java.util.Arrays;
import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        //func(1231242154);
        //System.out.println(addN(10));
        //System.out.println(addB(1234));
//        for(int i=1;i<=10;i++){
//            System.out.print(fib(i)+" ");
//        }

//        HannoiTa hannoi = new HannoiTa();
//        hannoi.hannoi(3,'A','B','C');

//        int[] arr = new int[3];
//        //System.out.println(arr);
//        for(int i:arr){
//            System.out.println(i);
//        }

        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(elementMulTwo2(arr)));
    }

    public static int[] elementMulTwo2(int[] arr){
        int[] arr2 = new int[arr.length];
        for(int i=0;i<arr2.length;i++){
            arr2[i]=arr[i]*2;
        }
        return arr2;
    }
    public static int[] elementMulTwo(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]*=2;
        }
        return arr;
    }

    /**
     * 求第n项斐波那契
     * @param n 第n项
     * @return  第n项斐波那契
     */
    public static int fib(int n){
        if(n<1){
            return -1;  //表示形参有误
        }
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    /**
     * 例如num=1234   return 1+2+3+4
     * @param num   上面的num
     * @return  上面的return
     */
    public static int addB(int num){
        if(num<0){
            return -1;  //表示num传参错误
        }
        if(num<10){
            return num;
        }
        return (num%10)+addB(num/10);
    }

    /**
     * 求1+2+3+...+n的值
     * @param n 上面表达式中的n
     * @return  表达式的结果
     */
    public static int addN(int n){
        if(n<1){
            return -1;  //表示n有误
        }
        if(n==1){
            return 1;
        }
        return n+addN(n-1);
    }

    /**
     * 把数字顺序输出，例如1234   输出1 2 3 4
     * @param num   需要顺序输出的数字
     */
    public static void func(int num){
        if(num%10==0){
            return;
        }
        func(num/10);
        System.out.print(num%10+" ");
    }
}
