package cn.itcast_05;

import java.io.*;

/*
 * 需求：把e:\\哥有老婆.mp4复制到当前项目目录下的copy.mp4
 *
 * 数据源   e:\\哥有老婆.mp4   FileIntputStream
 * 目的地   copy.mp4          FileOutputStream
 *
 * 字节流四种方式复制文件：
 * 基本字节流一次读写一个字节；
 * 基本字节流一次读写一个字节数组；
 * 高效字节流一次读写一个字节；
 * 高效字节流一次读写一个字节数组；
 *
 * */
public class CopyMp4Demo2 {
    public static void main(String[] args) throws IOException {
        //封装数据源和目的地
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e:\\哥有老婆.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.mp4"));

        //复制
        //高效字节流一次读写一个字节
        /*int by = 0;
        while ((by=bis.read()) != -1){
            bos.write(by);
        }*/

        //高效字节流一次读写一个字节数组
        byte[] bys = new byte[1024];
        int len=0;
        while ((len=bis.read(bys)) != -1){
            bos.write(bys,0,len);
        }
    }
}
