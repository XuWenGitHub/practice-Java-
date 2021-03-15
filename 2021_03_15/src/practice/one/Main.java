package practice.one;

import java.util.Scanner;

public class Main {
    /*
    2
2 6 5
1 2 3

3
0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //代表有几组测试用例
        for(int i=0;i<n;i++){
            int a = sc.nextInt();   //第一个数
            int b = sc.nextInt();   //第二个数
            int res = sc.nextInt(); //第三个数
            method(a,b,res);
        }
    }
    public static void method(int a,int b,int res){
        int[] a1 = getTwo(a);
        int[] b1 = getTwo(b);
        int[] res1 = getTwo(res);
        int num = 0;    //代表需要变换的次数
        for(int i=0;i<res1.length;i++){
            //代表当前res1中当前二进制位是1，还是0
            if(res1[i]==0){
                //如果是0，那么|的话，a1和b1当前位都要是0
                if(a1[i]==1){
                    num++;
                }
                if(b1[i]==1){
                    num++;
                }
            }else{
                //如果是1的话，只需要一个为1就可以
                if(a1[i]==0&&b1[i]==0){
                    num++;
                }
            }
        }
        System.out.println(num);

    }
    //获取一个数的二进制，用数组装起来
    public static int[] getTwo(int num){
        int[] res = new int[32];
        int index = 0;
        while(num!=0){
            if((num&1)==1){
                res[index] = 1;
            }
            num>>>=1;
            index++;
        }
        return res;
    }
}
