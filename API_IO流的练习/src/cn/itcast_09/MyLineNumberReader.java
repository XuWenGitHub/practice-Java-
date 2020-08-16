package cn.itcast_09;

import java.io.IOException;
import java.io.Reader;

public class MyLineNumberReader {
    private Reader r;
    private int lineNumber = 0;

    public MyLineNumberReader(Reader r){
        this.r = r;
    }


    public int getLineNumber() {
        //lineNumber++;
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String readLine()throws IOException {
        lineNumber++;

        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while ((ch=r.read())!=-1){
            if(ch=='\r'){
                continue;
            }

            if(ch=='\n'){
                return sb.toString();
            }else {
                sb.append((char) ch);
            }
        }

        //为了防止数据丢失，判断sb的长度不能大于0
        if(sb.length()>0){
            return sb.toString();
        }

        return null;
    }

    /*
     * 先写一个关闭方法
     * */
    public void close() throws IOException {
        this.r.close();
    }
}
