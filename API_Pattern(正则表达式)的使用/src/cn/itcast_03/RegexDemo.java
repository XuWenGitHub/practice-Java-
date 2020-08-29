package cn.itcast_03;

public class RegexDemo {
    public static void main(String[] args) {
        //定义一个字符串
        String s = "helloqq21321worldkh2321431312312312312java";

        //我要去除所有的数组，用*给替换掉
        //String regex = "\\d+";
        //String regex = "\\d";
        //String ss = "*";

        //直接把数字干掉
        String regex = "\\d+";
        String ss = "";

        String result = s.replaceAll(regex,ss);
        System.out.println(result);
    }
}
