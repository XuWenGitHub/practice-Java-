package cn.itcast_01;

import java.math.BigInteger;

public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("100");
        BigInteger bi2 = new BigInteger("50");

        //加减乘除
        System.out.println("add:"+bi1.add(bi2));
        System.out.println("subtract:"+bi1.subtract(bi2));
        System.out.println("multiply:"+bi1.multiply(bi2));
        System.out.println("divide:"+bi1.divide(bi2));

        BigInteger[] array = bi1.divideAndRemainder(bi2);
        System.out.println("商："+array[0]);
        System.out.println("余数："+array[1]);
    }
}
