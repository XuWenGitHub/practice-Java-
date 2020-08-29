package cn.itcast_02;

import java.util.Arrays;

/*
* 我有如下一个字符串："91 27 46 38 50"
* 请写代码实现最终输出结果："27 38 46 50 91"
*
* 分析：
*       A：定义一个字符串
*       B：把字符串进行分割，得到一个字符串数组
*       C：把字符串数组变换成int数组
*       D：对int数组排序
*       E：把排序后的int数组再组装成一个字符串
*       F：输出字符串
* */
public class RegexTest {
    public static void main(String[] args) {
       //定义一个字符串
       String s = "91 27 46 38 50";

       //把字符串进行分割，得到一个字符串数组
        String[] strArray = s.split(" ");

        //把字符串数组变换成int数组
        int[] array = new int[strArray.length];

        for(int i=0;i<array.length;i++){
            array[i]=Integer.parseInt(strArray[i]);
        }

        //对int数组排序
        Arrays.sort(array);

        //把排序后的int数组再组装成一个字符串
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<array.length;i++){
            sb.append(array[i]).append(" ");
        }
        //转换为字符串，再去掉前字符串后空格
        String result = sb.toString().trim();

        //输出字符串
        System.out.println(result);
    }
}
