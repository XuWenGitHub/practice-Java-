package cn.itcast_03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo2 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("a.txt");
        FileWriter fw = new FileWriter("b.txt");

        //复制
        char[] chs = new char[1024];
        int len=0;
        while ((len=fr.read(chs))!=-1){
            fw.write(chs,0,len);
        }

        //释放资源
        fr.close();
        fw.close();
    }
}
