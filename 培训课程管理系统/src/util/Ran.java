package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class Ran {
    public static void main(String[] args) throws IOException {
        Random r = new Random();
        BufferedWriter bw = new BufferedWriter(new FileWriter("student.txt"));
        for (int i = 0; i < 10000; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(r.nextInt(1000)+1).append(",").append(r.nextInt(10000)+1)
                    .append(",").append(r.nextInt(1000)).append(",").append(r.nextInt(10000)+1);
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
