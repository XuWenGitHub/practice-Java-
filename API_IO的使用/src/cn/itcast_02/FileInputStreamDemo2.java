package cn.itcast_02;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //创建字节输入流对象
        FileInputStream fis = new FileInputStream("FileOutputStreamDemo.java");

        byte[] bys = new byte[1024];
        int len=0;
        while ((len=fis.read(bys)) != -1){
            System.out.print(new String(bys,0,len));
        }

        //释放资源
        fis.close();
    }
}
