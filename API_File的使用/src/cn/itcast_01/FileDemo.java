package cn.itcast_01;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        //把C:\\Users\\Lenovo\\Desktop\\IDEA的File文件\\Flie的使用\\a.text封装成一个File对象
        File file = new File("C:\\Users\\Lenovo\\Desktop\\IDEA的File文件\\Flie的使用\\a.text");

        File file2 = new File("C:\\Users\\Lenovo\\Desktop\\IDEA的File文件\\Flie的使用","a.text");

        File file3 = new File("C:\\Users\\Lenovo\\Desktop\\IDEA的File文件\\Flie的使用");
        File file4 = new File(file3,"a.tex");

        //以上三种方式其实效果一样
    }
}
