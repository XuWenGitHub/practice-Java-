package cn.itcast_03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* 需求：把c盘下的a.txt的内容复制到d盘下的b.txt中
*
* 数据源：
*       c:\\a.txt   ---   读取数据   ---   FileInputStream
* 目的地
*       d:\\b.txt   ---   写入数据   ---   FileOutputStream
* */
public class CopyFileDemo2 {
    public static void main(String[] args) throws IOException {
        //封装数据源和目的地
        FileInputStream fis = new FileInputStream("c:\\a.txt");
        FileOutputStream fos = new FileOutputStream("d:\\b.txt");

        int by = 0;
        while ((by=fis.read()) != -1){
            fos.write(by);
        }

        //释放资源
        fis.close();
        fos.close();
    }
}
