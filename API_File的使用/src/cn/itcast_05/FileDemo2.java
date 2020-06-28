package cn.itcast_05;

import java.io.File;
import java.io.FilenameFilter;

/*
* 判断D盘目录下是否有后缀名为.java的文件，如果有，就输出此文件名称
*   A：先获取所有的，然后遍历的时候，如果满足条件就输出
*   B：获取的时候就已经是满足条件的了，然后输出即可
* */
public class FileDemo2 {
    public static void main(String[] args) {
        //封装E盘目录
        File file = new File("D:\\");

        //获取该迷路下的所有文件或者文件夹的String数组
        String[] strArray = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                //里面做判断功能
                /*File file1 = new File(file,s);
                Boolean flag = file1.isFile();
                Boolean flag2 = s.endsWith(".java");
                return flag&&flag2;*/

                return  new File(file,s).isFile()&&s.endsWith(".java");
            }
        });

        //遍历
        for(String s:strArray){
            System.out.println(s);
        }
    }
}
