package cn.itcast_04;

import java.io.*;

//需求：把当前项目目录下的a.txt内容复制到当前项目目录下的b.txt中
public class CopyFileDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("c.txt"));

        //复制
        char[] chs = new char[1024];
        int len=0;
        while ((len=br.read(chs))!=-1){
            bw.write(chs,0,len);
            bw.flush();
        }

        //释放资源
        br.close();
        bw.close();
    }
}
