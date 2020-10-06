package out.itcast_06;

import java.util.Scanner;

/*
* 判断一个字符串是否是对称字符串
* 例如"abc"不是对称字符串，"aba","abba","aaa","mnanm"是对称字符串
*
* 分析：
*       判断一个字符串是否是对称的字符串
*           第一个和最后一个比较
*           第二个和倒数第二个比较
*           ...
*       比较的次数是长度除以2
* */
public class StringBufferTest3 {
    public static void main(String[] args) {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s =sc.nextLine();

        //调用一个一个判断的方法
        isSame(s);

        //用字符串缓冲区的反转功能
        isSame2(s);
    }

    public static void isSame(String s){
        //把字符串转成字符数组
        char[] array = s.toCharArray();

        //定义比较的次数count
        int count = 0;

        //开始一个一个的比较
        for(int i=0,j=array.length-1;count<array.length/2;i++,j--){
            if(array[i]==array[j]){
                count++;
            }else {
                System.out.println(s+"不是对称字符串");
                break;
            }
        }
        if(count==(array.length/2)){
            System.out.println(s+"是对称的字符串");
        }
    }

    public static void isSame2(String s){
        /*StringBuffer sb = new StringBuffer();
        sb.append(s);

        StringBuffer sb2 = new StringBuffer();
        sb2.append(s);
        sb2.reverse();

        if(sb2.toString().equals(sb.toString())){
            System.out.println(s+"是对称的字符串");
        }else {
            System.out.println(s+"不是对称字符串");
        }*/

        //链式编程
        if(new StringBuffer(s).reverse().toString().equals(s)){
            System.out.println(s+"是对称的字符串");
        }else {
            System.out.println(s+"不是对称字符串");
        }
    }
}
