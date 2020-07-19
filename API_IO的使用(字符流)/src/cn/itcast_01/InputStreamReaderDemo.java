package cn.itcast_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        //创建对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream("osw.txt"),"UTF-8");

        //读取数据
        int ch=0;
        while ((ch=isr.read())!=-1){
            System.out.print((char) ch);
        }

        //释放资源
        isr.close();
    }
}
