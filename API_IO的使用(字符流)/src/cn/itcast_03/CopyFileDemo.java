package cn.itcast_03;

import java.io.*;

/*
* 需求：把当前项目目录下的a.txt内容复制到当前项目目录下的b.txt中
*
* 数据源    a.txt
* 目的地    b.txt
* */
public class CopyFileDemo {
    public static void main(String[] args) throws IOException {
        //封装数据源和目的地
        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("b.txt"));

        //复制
        /*int ch=0;
        while ((ch=isr.read())!=-1){
            osw.write(ch);
        }*/

        int ch=0;
        while((ch=isr.read())!=-1){
            osw.write(ch);
        }

//        char[] chs = new char[1024];
//        int len=0;
//        while ((len=isr.read(chs))!=-1){
//            osw.write(chs,0,len);
//            osw.flush();
//        }

        //释放资源
        osw.close();
        isr.close();
    }
}
