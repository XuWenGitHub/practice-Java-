package practice.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
interface a{

}
interface b extends a{

}
/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/18 9:23
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        //String str = "abcdef";
        //System.out.println(reverse(str,1,3));
        //System.out.println(reverse(str,3,str.length()));
//        System.out.println(spin(str,1));
//        System.out.println(spin2(str,1));
//        System.out.println(str.length());


        //System.out.println(strReverse("i am a student"));

        //System.out.println(strZip("abbcccffr"));

//        int[][] arr = new int[3][2];
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);

        //System.out.println(StrToInt("-1236567565656"));

//        int a=0;
//        int A=0;

//        int[] arr = {3,2,6,3,1,9,2,6,1};
//        System.out.println(findOneNum(arr));

        //System.out.println(isTwoPow(32));

        System.out.println(nickCut(1));
    }


    //验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
    /*
    1^3=1 2^3=3+5 3^3=7+9+11 4^3=13+15+17+19
    基数从：m*m-2*(m/2)
    偶数从：m*m-2*(m/2)+1
     */
    public static String nickCut(int num){
        StringBuilder sb = new StringBuilder();
        int result=0;
        //基数：num*num-2*(num/2)
        //偶数：num*num-2*(num/2)+1
        if(num%2==1){
            result = num*num-2*(num/2);
        }else{
            result = num*num-2*(num/2)+1;
        }
        sb.append(result);
        for(int i=1;i<num;i++){
            sb.append("+");
            sb.append(result+i*2);
        }
        sb.append("=").append((long) Math.pow(num,3));
        return sb.toString();
    }


    //找出一组数字中的不重复的数字，数字构成为：1到n的序列，n是数组长度。只有一个不重复的数字，【空间复杂
    //度O(1),时间O(n)平方，不能修改数组内容。不能对数组进行排序】
    //示例：int[] array = {3,2,6,3,1,9,2,6,1}; 出现1次的数字就是 9。
    public static int findOneNum(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;  //表示没有找到
    }


    //输入一行字符，统计字符串中数字个数
    //示例："bit666keji123" 数字的个数为：6个
    public static int strNum(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                count++;
            }
        }
        return count;
    }

    /*
    请你写一个函数 StrToInt ，实现把字符串转换成整数(int)这个功能。 不能使用 Integer.valueOf() 函数。要求不
    能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0，如果转换后的数字，超过了
    整形的最大值或者最小值，那么函数只需 返回最大值或者最小值
    "2147483647" ==》2147483647
    示例二：超过了整形的最大值 用int的最大值表示 "2147483648" ==》2147483647
    示例三：数值不合法 "123abcd" ==》 0
     */
    public static int StrToInt(String s){
        long result=0;  //用long类型，最后强转成int，如果超过int，或者小于int，直接返回最大值或者最小值即可
        boolean flag = true;    //true表示正数，false表示负数
        char first = s.charAt(0);
        if(first=='+'){
        }else if(first=='-'){
            flag=false;
        }else if(first>='0'&&first<='9'){
            result+=(first-'0');
        }
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);  //取出当前字符
            if(ch>='0'&&ch<='9'){
                result*=10;
                result+=(ch-'0');
            }else{
                return 0;
            }
        }
        //给正负号
        if(!flag){
            result= -result;
        }

        //判断是否越界
        if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)result;
    }


    //将用户输入的字符串转化（压缩）。
    //例如： "aabbccdaa" -> "a2b2c2d1a2" 或者 例如："abbcccffr" -> "a1b2c3f2r1"
    public static String strZip(String str){
        StringBuilder sb = new StringBuilder();
        int num = 0;    //表示当前字符个数
        char ch=str.charAt(0);    //表示当前字符
        for(int i=0;i<str.length();i++){
            if(ch==str.charAt(i)){
                num++;
            }else{
                sb.append(ch).append(num);
                ch=str.charAt(i);
                num=1;
            }
        }
        sb.append(ch).append(num);
        return sb.toString();
    }

    //字符串逆置，如 "I am a student" 逆置为 "student a am I" 。
    public static String strReverse(String str){
        StringBuilder sb = new StringBuilder();
        String[] strings = str.split(" ");
        for(int i=strings.length-1;i>=0;i--){
            sb.append(strings[i]).append(" ");
        }
        return sb.toString();
    }


    //将一个数组从左开始前k个字符进行旋转：左旋数组
    //如：将"abcdef"当k等于2时，进行旋转，得到结果为："cdefab"
    /*
    方法1：字符串部分逆置
     */
    public static String spin(String str,int k){
        if(k > str.length() || k < 1 || str.equals("")){
            return str;
        }
        //先旋转字符串1-k个字符
        str = reverse(str,1,k);
        str = reverse(str,k+1,str.length());
        str = reverse(str,1,str.length());
        return str;
    }
    //字符串部分逆置[start,end],start从1开始
    public static String reverse(String str,int start,int end){
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for(int i=1;i<=chars.length;i++){
            if(i>=start&&i<=end){
                stack.push(chars[i-1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=chars.length;i++){
            if(i>=start&&i<=end){
                sb.append(stack.pop());
            }else {
                sb.append(chars[i - 1]);
            }
        }
        return sb.toString();
    }

    /*
    判断一个数是不是2的多少次方，不需要知道有多少个次方
    考虑2的k次方数的特点，每一个2的k次方数转化为2进制之后，只有一位为1，我们只需要判断二进制位上是不是只有一个1
     */
    public static boolean isTwoPow(int value){
        int num=0;
        while(value!=0&&num<2){
            if((value&1)==1){
                num++;
            }
            value>>>=1;
        }
        return num < 2;
    }

    /*
    方法2：做一个2倍串
    将"abcdef"当k等于2时，进行旋转，得到结果为："cdefab"
     */
    public static String spin2(String str,int k){
        if(k > str.length() || k < 1 || str.equals("")){
            return str;
        }
        String twoStr = str.concat(str);
        return twoStr.substring(k,str.length()+k);
    }
}
