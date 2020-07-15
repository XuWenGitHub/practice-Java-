package cn.itcast_01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("fos2.txt");

        //写数据
        /*fos.write(97); //97为ASCII码表对应的
        fos.write(57);
        fos.write(55);*/

        byte[] array = {97,98,99,100,101};
        fos.write(array);

        fos.write(array,1,3);

        //释放资源
        fos.close();
    }
}
