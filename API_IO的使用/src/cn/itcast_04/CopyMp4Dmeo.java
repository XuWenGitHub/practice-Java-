package cn.itcast_04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 需求：把e:\\哥有老婆.mp4复制到当前项目目录下的copy.mp4
 *
 * 数据源：e:\\哥有老婆.mp4  读取数据  FileInputStream
 * 目的地：copy.mp4  写入数据  FileOutputStream
 * */
public class CopyMp4Dmeo {
    public static void main(String[] args) throws IOException {
        //封装数据源和目的地
        FileInputStream fis = new FileInputStream("e:\\哥有老婆.mp4");
        FileOutputStream fos = new FileOutputStream("copy.mp4");

        //复制
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len=fis.read(bys)) != -1){
            fos.write(bys,0,len);
        }

        //释放资源
        fis.close();
        fos.close();
    }
}
