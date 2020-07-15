package cn.itcast_02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建字节输入流对象
        FileInputStream fis = new FileInputStream("fis.txt");

        //调用read()方法读取数据，并把数据显示在控制台
        /*int by = fis.read();
        while (by!=-1){
            System.out.print((char)by);
            by=fis.read();
        }*/

        int by=0;
        //读取，赋值，判断
        while ((by=fis.read()) != -1){
            System.out.print((char) by);
        }

        //释放资源
        fis.close();
    }
}
