package cn.itcast_04;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        //指定一个目录
        File file = new File("C:\\");

        String[] strArray = file.list();
        for(String s :strArray){
            System.out.println(s);
        }
        System.out.println("-----------");

        File[] fileArray = file.listFiles();
        for(File f:fileArray){
            System.out.println(f.getName());
        }
    }
}
