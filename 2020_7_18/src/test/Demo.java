package test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        //findNine();

        //printLeapYear(1000,2000);

        //printPrime(1,100);

        //System.out.println(isPrime(-1));

        //ageGroup();

        //GuessNumber guessNumber = new GuessNumber();
        //guessNumber.start();

        //printDaffodilsNumber(0,999);

        //calResult();

        //greatCommonDivisor(100,125);

        //System.out.println(oneNumber(-2));

        //changeBinary(213);

        //printDigit(1243313);

        printMultiplicationTable();
    }
    //输出乘法口诀表
    public static void printMultiplicationTable(){
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.printf("%d*%d=%d ",j,i,(j*i));
            }
            System.out.println();
        }
    }

    //输出一个整数的每一位，如：123的每一位是1 ， 2 ， 3
    public static void printDigit(int num){
        Stack<Integer> stack = new Stack<>();
        int number=num; //先看num有多少位
        int dight=0;
        while(number!=0){
            dight++;
            number/=10;
        }
        //System.out.println(dight);
        while(dight>0){
            stack.push(num%10);
            num/=10;
            dight--;
        }
        for(int i=stack.size();i>0;i--) {
            if(i==1){
                System.out.printf("%d", stack.pop());
            }else {
                System.out.printf("%d ,", stack.pop());
            }
        }
        System.out.println();
    }


    //获取一个数二进制序列中所有的偶数位和奇数位，分别输出二进制序列
    public static void changeBinary(int a){
        Stack<Integer> oddStack = new Stack<>();    //存奇数的栈，上下两个栈都为了逆序输出
        Stack<Integer> evenStack= new Stack<>();    //存偶数的栈
        boolean flag=true;  //true表示奇数，false表示偶数
        while(a!=0){
            if(flag){
                //表示奇数位，应该存入奇数的栈
                oddStack.push((a&1));
                a>>>=1; //无符号右移一位
                flag=false;
            }else {
                //表示偶数位，应该存入偶数的栈
                evenStack.push((a&1));
                a>>>=1;
                flag=true;
            }
        }
        //打印奇数位
        System.out.print("奇数位：");
        for(int i=oddStack.size();i>0;i--){
            int j=oddStack.pop();
            System.out.printf("%d ",j);
        }
        System.out.println();
        //打印偶数位
        System.out.print("偶数位：");
        for(int i=evenStack.size();i>0;i--){
            int j=evenStack.pop();
            System.out.printf("%d ",j);
        }
        System.out.println();
    }

    //求一个整数，在内存当中存储时，二进制1的个数
    public static int oneNumber(int num){
        int count=0;
        while(num!=0){
            if((num&1)==1){
                count++;
            }
            num>>>=1;   //这里要无符号右移，左边要补0，不然负数，一直左边补1
        }
        return count;
    }

    //求两个正整数的最大公约数
    public static void greatCommonDivisor(int num1,int num2){
        //相减法，原理：他们都是由很多个最大公约数相加
        int a=num1;
        int b=num2;
        while(Math.abs(a-b)!=0){
            if(a>b){
                a-=b;
            }else {
                b-=a;
            }
        }
        System.out.println(num1+"和"+num2+"的最大公约数为："+a);
    }

    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值 。
    public static void calResult(){
        int plus=1;
        double result=0;
        for(int i=1;i<=100;i++){
            //double j=(plus)*(1/(i*1.0));
            result=result+(plus)*(1/(i*1.0));   //千万不要忘记乘i乘1.0,不然都舍弃小数部分了
            plus=-plus; //改变正负号
        }
        System.out.println(result);
    }

    /*
    求出0～999之间的所有“水仙花数”并输出。
    (“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身，
    如；153＝1＋5＋3?，则153是一个“水仙花数“。）
     */
    public static void printDaffodilsNumber(int start,int end){
        for(int i=start;i<=end;i++){
            if(i/100!=0&&i/1000==0){
                int ge=i%10;
                int shi=(i/10)%10;
                int bai=(i/10/10)%10;
                if((Math.pow(ge,3)+Math.pow(shi,3)+Math.pow(bai,3))==i){
                    System.out.println(i+"是水仙花数");
                }
            }

        }
    }

    /*
    根据输入的年龄, 来打印出当前年龄的人是少年(低于18),
    青年(19-28),
    中年(29-55),
    老年(56以上)
     */
    public static void ageGroup(){
        Scanner sc = new Scanner(System.in);
        boolean flag=true;
        while (flag) {
            System.out.println("请输入年龄");
            int age = sc.nextInt();
            if (age >= 0 && age <= 18) {
                System.out.println(age + "岁是少年");
            } else if (age >= 19 && age <= 28) {
                System.out.println(age + "岁为青年");
            } else if (age >= 29 && age <= 55) {
                System.out.println(age + "岁是中年");
            } else if (age >= 56) {
                System.out.println(age + "岁是老年");
            } else {
                System.out.println("年龄输入有误");
            }
            System.out.println("是否退出 2:退出");
            int i=sc.nextInt();
            if(i==2){
                flag=false;
            }
        }
    }

    //给定一个数字，判定一个数字是否是素数
    public static boolean isPrime(int num){
        if(num<1){
            //如果一个数小于1，那么就一定不是素数
            return false;
        }
        boolean flag=true;
        for(int j=2;j<=Math.sqrt(num);j++){
            if(num%j==0){
                flag=false;
                break;
            }
        }
        return flag;
    }

    //打印 1 - 100 之间所有的素数
    public static void printPrime(int start,int end){
        for(int i=start;i<=end;i++){
            boolean flag=true;  //最后判断是不是素数
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println(i+"为素数");
            }
        }
    }
    /**
     * 输出 1000 - 2000 之间所有的闰年
     * @param start 起始点
     * @param end   结束点
     */
    public static void printLeapYear(int start,int end){
        //ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=start;i<=end;i++){
            if((i%4==0&&i%100!=0)||(i%400==0)){
                //arrayList.add(i);
                System.out.println("闰年："+i);
            }
        }
        //System.out.println(arrayList);
    }

    /*
    编写程序数一下 1到 100 的所有整数中出现多少个数字9
     */
    public static void findNine(){
        int sum=1;  //统计1~100中的数字9
        //1~9里只有一个9，100里没有9，所有只需要判断10~99
        for(int i=10;i<=99;i++){
            int num=i/10;  //十位
            int digit=i%10;   //个位
            if(digit==9){
                sum++;
            }
            if(num==9){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
