package cn.itcast_01;

import java.io.*;

/*
* 复制文本文件
*
* 分析：
*       复制数据，如果我们知道用记事本打开能够读懂，就用字符流，否则就用字节流
*       通过该原理，我们知道我们应该采用字符流更方便一些
*       而字符流有五种方式，所以做这个题目我们有5中方式，推荐掌握第五种
* 数据源：
*       c:\\a.txt -- FileReader -- BufferedReader
* 目的地：
*       d:\\b.txt -- FileWriter -- BufferedWriter
* */
public class CopyFileDemo {
    public static void main(String[] args) throws IOException{
        String srcString = "c:\\a.txt";
        String destString = "d:\\b.txt";
        //method1(srcString,destString);
        //method2(srcString,destString);
        //method3(srcString,destString);
        //method4(srcString,destString);
        method5(srcString,destString);
    }
    //高效字符流，一次读写一个字符串
    public static void method5(String srcString,String destString)throws IOException {
        //封装数据源和目的地
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destString));


        //复制
        String line = null;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        br.close();
        bw.close();
    }

    //第四种方式，高效字符流，一次读取一个字符数组
    public static void method4(String srcString,String destString)throws IOException {
        //封装数据源和目的地
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destString));


        //复制
        char[] chs = new char[1024];
        int len=0;
        while ((len=br.read(chs))!=-1){
            bw.write(chs,0,len);
        }

        //释放资源
        br.close();
        bw.close();
    }

    //第三种方式，高效字符流，一次读取一个字符
    public static void method3(String srcString,String destString)throws IOException {
        //封装数据源和目的地
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destString));


        //复制
        int ch=0;
        while ((ch=br.read())!=-1){
            bw.write(ch);
        }

        //释放资源
        br.close();
        bw.close();
    }

    //第一种方式，基本字符流，一次读写一个字符
    public static void method1(String srcString,String destString)throws IOException {
        //封装数据源和目的地
        FileReader fr = new FileReader("srcString");
        FileWriter fw = new FileWriter("destString");

        //复制
        int ch=0;
        while ((ch=fr.read())!=-1){
            fw.write(ch);
        }

        //释放资源
        fr.close();
        fw.close();
    }

    //第二种方式，基本字符流。一次读写一个字符数组
    public static void method2(String srcString,String destString)throws IOException {
        //封装数据源和目的地
        FileReader fr = new FileReader("srcString");
        FileWriter fw = new FileWriter("destString");

        //复制
        char[] chs = new char[1024];
        int len = 0;
        while ((len=fr.read(chs))!=-1){
            fw.write(chs,0,len);
        }

        //释放资源
        fr.close();
        fw.close();
    }
}
