package cn.itcast_02;

public class RegexDemo2 {
    public static void main(String[] args) {
        //定义一个字符串
        String s1 = "aa,bb,cc";
        //直接分割
        String[] strArray=s1.split(",");
        for(int i=0;i<strArray.length;i++){
            System.out.println(strArray[i]);
        }
        System.out.println("---------------------");

        String s2 = "aa.bb.cc";
        String[] str2Array=s2.split("\\.");
        for(int i=0;i<str2Array.length;i++){
            System.out.println(str2Array[i]);
        }
        System.out.println("---------------------");

        String s3 = "aa      bb          cc";
        String[] str3Array=s3.split(" +");
        for(int i=0;i<str3Array.length;i++){
            System.out.println(str3Array[i]);
        }
        System.out.println("---------------------");

        //硬盘上的路径，我们应该用\\代替\
        String s4 = "D:\\idea项目（工程）\\API_Pattern(正则表达式)的使用";
        String[] str4Array=s4.split("\\\\");
        for(int i=0;i<str4Array.length;i++){
            System.out.println(str4Array[i]);
        }
        System.out.println("---------------------");
    }
}
