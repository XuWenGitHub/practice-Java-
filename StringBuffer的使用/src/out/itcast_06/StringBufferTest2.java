package out.itcast_06;

import java.util.Scanner;

/*
* 把字符串反转
* */
public class StringBufferTest2 {
    public static void main(String[] args) {
        //键盘录入数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要反转的数据：");
        String s = sc.nextLine();

        //方式1：用String做反转
        System.out.println(stringReverse(s));

        //方式2：用StringBuffer做反转
        System.out.println(stringReverse2(s));
    }

    //用String做反转
    public static String stringReverse(String s){
        String result="";

        char[] array = s.toCharArray();
        for(int i=array.length-1;i>=0;i--){
            result+=array[i];
        }

        return result;
    }

    //用StringBuffer做反转
    public static String stringReverse2(String s){
        //StringBuffer sb = new StringBuffer();
        //sb.append(s);
        //sb.reverse();
        //return sb.toString();

        //简易版，链式编程
        return new StringBuffer(s).reverse().toString();
    }
}
