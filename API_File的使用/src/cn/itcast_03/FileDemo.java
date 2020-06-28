package cn.itcast_03;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        //创建文件
        File file = new File("d:\\a.txt");
        System.out.println(file.createNewFile());

        //删除
        System.out.println(file.delete());

        //创建文件
        File file1 = new File("a.txt");
        System.out.println(file1.createNewFile());

       /* //继续玩几个
        File file2 = new File("aaa\\bbb\\ccc");
        System.out.println(file2.mkdirs());*/

        //我要删除a.txt这个文件
        File file3 = new File("a.txt");
        System.out.println(file3.delete());

        //我要删除aaa\bbb\ccc
        /*File file4 = new File("aaa\\bbb\\ccc");
        System.out.println(file4.delete());*/

        File file4 = new File("aaa\\bbb");
        System.out.println(file4.delete());

        File file2 = new File("aaa");
        System.out.println(file2.delete());


    }
}
