package cn.itcast_01;

/*
* 需求1：我要求大家把100这个数据的二进制，八进制，十六进制计算出来
* 需求2：我要求大家判断一个数据是否是int范围内的。
*           首先你得知道int的范围是多大？
* */
public class IntegerDemo {
    public static void main(String[] args) {
        //不麻烦的就来了
        //public static String toBinaryString(int i)
        System.out.println(Integer.toBinaryString(100));

        //public static String toOctalString(int i)
        System.out.println(Integer.toOctalString(100));

        //public static String toHexString(int i)
        System.out.println(Integer.toHexString(100));

        //int的范围是多大？
        System.out.println(Integer.MIN_VALUE+"---"+Integer.MAX_VALUE);

        //十进制到其他进制
        System.out.println(Integer.toString(100,10));
        System.out.println(Integer.toString(100,2));
        System.out.println(Integer.toString(100,8));
        System.out.println(Integer.toString(100,16));
        System.out.println(Integer.toString(100,5));
        
    }
}
