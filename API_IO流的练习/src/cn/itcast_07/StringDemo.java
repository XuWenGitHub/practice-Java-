package cn.itcast_07;

import java.io.*;
import java.util.Arrays;

/*
* 已知s.txt文件中有这样的一个字符串："hcexfgijkamdnoqrzetuvwybpl"
* 请编写程序读取数据内容，把数据排序后写入ss.txt中
*
* 分析：
*       A：把s.txt这个文件给做出来
*       B：读取该文件的内容，存储到一个字符串中
*       C：把字符串转换为字符数组
*       D：对字符数组进行排序
*       E：把顺序后的字符数组转换为字符串
*       F：把字符串再次写入ss.txt中
* */
public class StringDemo {
    public static void main(String[] args) throws IOException {
        //读取该文件的内容，存储到一个字符串中
        BufferedReader br = new BufferedReader(new FileReader("s.txt"));
        String line = br.readLine();
        br.close();

        //把字符串转换为字符数组
        char[] chs = line.toCharArray();

        //对字符数组进行排序
        Arrays.sort(chs);

        //把顺序后的字符数组转换为字符串
        String s = new String(chs);

        //把字符串再次写入ss.txt中
        BufferedWriter bw = new BufferedWriter(new FileWriter("ss.txt"));
        bw.write(s);
        bw.newLine();
        bw.flush();


        bw.close();
    }
}
