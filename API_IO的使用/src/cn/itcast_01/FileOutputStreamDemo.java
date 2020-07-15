package cn.itcast_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* 需求：我要往一个文本文件中输入一句话：hello,io.
*
*
* */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建字节输出流对象
        /*File file = new File("fos.txt");
        FileOutputStream fos = new FileOutputStream(file);*/

        FileOutputStream fos = new FileOutputStream("fos.txt");

        //写数据
        fos.write("hello,io".getBytes());

        //释放资源
        //关闭此文件输出并释放与此流有关的所以系统资源
        fos.close();
    }
}
