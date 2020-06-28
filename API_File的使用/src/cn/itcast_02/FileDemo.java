package cn.itcast_02;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        //需求：我要在D盘目录下创建一个文件夹demo
        File file = new File("d:\\demo");
        System.out.println("mkdir:"+file.mkdir());
        System.out.println(file.delete());

        //需求：我要在d盘目录demo下创建一个文件a.tet
       /* File file1 = new File("d:\\demo\\a.txt");
        System.out.println("createNewFile:"+file1.createNewFile());
        System.out.println(file1.delete());*/

        //有更简单的方法
        File file2 = new File("d:\\aaa\\bbb\\ccc\\ddd\\fff");
        System.out.println("mkdirs："+file2.mkdirs());
    }
}
