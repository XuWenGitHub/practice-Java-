package cn.itcast_09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("my.txt"));

        String line = null;
        while ((line=lnr.readLine())!=null){
            System.out.println(lnr.getLineNumber()+":"+line);
        }

        lnr.close();
    }
}
