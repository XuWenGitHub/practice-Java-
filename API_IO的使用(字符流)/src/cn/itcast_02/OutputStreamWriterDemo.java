package cn.itcast_02;

import java.io.*;

public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        //创建对象
        OutputStreamWriter osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("osw.txt")));
        FileWriter fw = new FileWriter("osw.txt");
        //写入数据
        osw.write("我爱你",0,3);
        //fw.write("asdasd",0,3);
        //释放资源
        osw.close();
        fw.close();
    }
}
