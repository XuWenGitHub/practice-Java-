package cn.itcast_03;

import java.util.Arrays;

/*
* 计算机是如何识别什么时候该把两个字节转换为一个中文呢？
* 在计算机中中文的存储分两个字节：
*       第一个字节肯定是负数。
*       第二个字节常见的是负数，可能有整数，但是没有影响
* */
public class StringDemo {
    public static void main(String[] args) {

        String s="我爱你中国";
        //[-26, -120, -111, -25, -120, -79, -28, -67, -96, -28, -72, -83, -27, -101, -67]
        byte[] bys = s.getBytes();
        System.out.println(Arrays.toString(bys));
    }
}
