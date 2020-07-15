package cn.itcast_03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* 需求：把e:\\哥有老婆.mp4复制到当前项目目录下的copy.mp4
*
* 数据源：e:\\哥有老婆.mp4  读取数据  FileInputStream
* 目的地：copy.mp4  写入数据  FileOutputStream
* */
public class CopyMp4Demo {
    public static void main(String[] args) throws IOException {
        //封装数据源和目的地
        FileInputStream fis = new FileInputStream("\\哥有老婆.mp4");
        FileOutputStream fos = new FileOutputStream("copy.mp4");

        //太慢了，不推荐
//        int by=0;
//        while ((by=fis.read()) != -1){
//            fos.write(by);
//        }
        byte[] bys = new byte[1024];
        int len=0;
        while ((len=fis.read()) != -1){
            fos.write(bys,0,len);//有问题的
        }

        //释放资源
        fos.close();
        fis.close();
    }
}
