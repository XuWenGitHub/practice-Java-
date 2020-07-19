package cn.itcast_04;

import java.io.*;

//需求：把当前项目目录下的a.txt内容复制到当前项目目录下的b.txt中
public class CopyFileDemo2 {
    public static void main(String[] args) throws IOException {
        //封装数据源和目的地
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("d.txt"));

        //复制
        String line = null;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        br.close();
        bw.close();
    }
}
