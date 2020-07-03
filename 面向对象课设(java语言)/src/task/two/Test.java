package task.two;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        BufferedReader br = new BufferedReader(new FileReader("out.txt"));

        String s=new String("");
        int flag2=1;
        boolean flag = true;
        int left=0;
        int right=0;
        while (flag) {
            Scanner sc = new Scanner(System.in);
            Scanner str = new Scanner(System.in);
            System.out.println("请输入left操作数");
            if(sc.hasNextInt()) {
                left = sc.nextInt();
            }else{
                System.out.println("操作数不正确");
                continue;
            }
            System.out.println("请输入right操作数");
            if(sc.hasNextInt()) {
                right = sc.nextInt();
            }else{
                System.out.println("操作数不正确");
                continue;
            }

            //Calc calc = new Calc(); //会出异常
            Calc calc = new Calc(left, right); //计算器对象
            System.out.println("请输入运算符+ - * /");
            s = str.nextLine();

            switch (s){
                case "+":
                    System.out.println(left+"+"+right+"="+calc.add());
                    write(left,right,calc.add(),"+",bw);
                    break;
                case "-":
                    System.out.println(left+"-"+right+"="+calc.sub());
                    write(left,right,calc.sub(),"-",bw);
                    break;
                case "*":
                    System.out.println(left+"*"+right+"="+calc.mul());
                    write(left,right,calc.mul(),"*",bw);
                    break;
                case "/":
                    System.out.println(left+"/"+right+"="+calc.div());
                    write(left,right,calc.div(),"/",bw);
                    break;
                default:
                    System.out.println("操作符输入不正确");
            }
            System.out.println("请选择是否还要继续使用计算器：");
            System.out.println("1:使用   2:不使用  选择其他便是使用");
            flag2=sc.nextInt();
            if(flag2==2){
                flag=false;
            }
        }

        System.out.println("您运算的表达式以存入out.txt文件，下面为您显示");
        //读取out.txt数据,一次读取一行
        String line = null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        //释放资源
        bw.close();
        br.close();
    }
    //将运算表达式写入文件
    public static void write(int left,int right,int v,String s,BufferedWriter bw) throws IOException {
        String value = "";
        value+=left;
        value+="+";
        value+=right;
        value+="=";
        value+=v;
        bw.write(value);
        bw.newLine();
        bw.flush();
    }
}
