package cn.itcast_02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        //创建对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream("osw.txt"));

        //读数据
        /*int ch = 0;
        while ((ch=isr.read())!=-1){
            System.out.print((char) ch);
        }*/

        char[] chs = new char[1024];
        int len=0;
        while ((len=isr.read(chs))!=-1){
            System.out.print(new String(chs,0,len));
        }

        //释放资源
        isr.close();
    }
}
