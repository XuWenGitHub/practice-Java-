package out.itcast_01;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        //创建对象
        Scanner sc = new Scanner(System.in);
        //获取数据
        if(sc.hasNextInt()){
            int a = sc.nextInt();
            System.out.println("a:"+a);
        }else{
            System.out.println("您输入的数据有误");
        }
    }
}
