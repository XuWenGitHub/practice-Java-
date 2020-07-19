package cn.itcast_04;

import java.io.*;

public class BufferedDemo {
    public static void main(String[] args) throws IOException{
        write();
        read();

    }

    public static void write() throws IOException {
        //创建字符缓冲输出对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("bw.txt"));
        for(int i=0;i<10;i++){
            bw.write("hello"+i);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
    }

    public static void read() throws IOException{
        //创建字符缓冲输出流对象
        BufferedReader br = new BufferedReader(new FileReader("bw.txt"));
        String line = null;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }

        //释放资源
        br.close();
    }
}
