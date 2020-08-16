package cn.itcast_01;

import java.io.*;

/*
* 复制图片
*
* 分析：用记事本来开肯定读不懂，所以用字节流
*       而字节流有4种方式，所以做这个题目我们有4中方式，推荐掌握第四种
*
* 数据源：
*       c:\\a.jpg -- FileInputStream -- BufferedInputStream
* 目的地：
*       d:\\b.jpg -- FileOutputStream -- BufferedOutputStream
* */
public class CopyImageDemo {
    public static void main(String[] args) throws IOException {
        String srcString = "c:\\a.txt";
        String destString = "d:\\b.txt";
        //method1(srcString,destString);
        //method2(srcString,destString);
        //method3(srcString,destString);
        method4(srcString,destString);
    }

    //第四种方式，高效字节流，一次读取一个字节数组
    public static void method4(String srcString,String destString)throws IOException {
        //封装数据源和目的地
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));

        //复制
        byte[] bys = new byte[1024];
        int len=0;
        while ((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }

        //释放资源
        bis.close();
        bos.close();
    }

    //第三种方式，高效字节流，一次读取一个字节
    public static void method3(String srcString,String destString)throws IOException {
        //封装数据源和目的地
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));

        //复制
        int by = 0;
        while ((by=bis.read())!=-1){
            bos.write(by);
        }

        //释放资源
        bis.close();
        bos.close();
    }

    //第二种方式，基本字节流，一次读取一个字节数组
    public static void method2(String srcString,String destString)throws IOException {
        //封装数据源和目的地
        FileInputStream fis = new FileInputStream(srcString);
        FileOutputStream fos = new FileOutputStream(destString);

        //复制
        byte[] bys = new byte[1024];
        int len=0;
        while ((len=fis.read(bys))!=-1){
            fos.write(bys,0,len);
        }

        //释放资源
        fis.close();
        fos.close();
    }

    //第一种方式，基本字节流，一次读取一个字节
    public static void method1(String srcString,String destString)throws IOException {
        //封装数据源和目的地
        FileInputStream fis = new FileInputStream(srcString);
        FileOutputStream fos = new FileOutputStream(destString);

        //复制
        int by = 0;
        while ((by=fis.read())!=-1){
            fos.write(by);
        }

        //释放资源
        fis.close();
        fos.close();
    }
}
