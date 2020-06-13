package out.itcast_02;

import java.util.Scanner;

/*先获取一个数值，在获取一个字符串，会出现问题。
 主要原因：就是那个换行符号的问题.*/
public class ScannerDemo {
    public static void main(String[] args) {
        //创建对象
        Scanner sc = new Scanner(System.in);

        //调用方法
        /*  这是有问题的
        int a = sc.nextInt();
        String s = sc.nextLine();
        System.out.println("a:"+a+",s:"+s);
         */

        //对象调用方法
        int a = sc.nextInt();
        Scanner sc2 = new Scanner(System.in);
        String s = sc2.nextLine();
        System.out.println("a:"+a+",s:"+s);
    }
}
