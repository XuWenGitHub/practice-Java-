package cn.itcast_09;

import java.io.FileReader;
import java.io.IOException;

public class MyLineNumberReader2Test {
    public static void main(String[] args) throws IOException {
        MyLineNumberReader2 mlnr = new MyLineNumberReader2(new FileReader("my.txt"));

        System.out.println(mlnr.getLineNumber());
        System.out.println(mlnr.getLineNumber());
        System.out.println(mlnr.getLineNumber());

        String line = null;
        while ((line=mlnr.readLine())!=null){
            System.out.println(mlnr.getLineNumber()+":"+line);
        }

        mlnr.close();
    }
}
