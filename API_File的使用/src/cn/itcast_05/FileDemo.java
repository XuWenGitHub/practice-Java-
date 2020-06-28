package cn.itcast_05;

import java.io.File;

/*
* 判断D盘目录下是否有后缀名为.java的文件，如果有，就输出此文件名称
*
* 分析：
*       A：封装D盘目录
*       B：获取该目录下的所有文件或者文件夹的File数组
*       C：遍历File数组，得到每一个File对象，然后判断
*       D：是否是文件
*           是：继续判断是否以.java结尾
*                   是：就输出该文件名称
*                   否：不搭理它
*           否：不搭理它
* */
public class FileDemo {
    public static void main(String[] args) {
        //封装D盘目录
        File file = new File("D:\\");

        //获取该目录下的所有文件或者文件夹的File数组
        File[] fileArray = file.listFiles();

        //遍历File数组，得到每一个File对象，然后判断
        for(File f:fileArray){
            //是否是文件
            if(f.isFile()){
                //继续判断是否以.java结尾
                if(f.getName().endsWith(".java")){
                    //是：就输出该文件名称
                    System.out.println(f.getName());
                }else{
                    //否：不搭理它
                }

            }else {
                //否：不搭理它
            }

        }
    }
}
