package practice.three;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        //System.out.println(convert2("abcde", 4));
        System.out.println("double最大值和最小值");
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println("int最大值和最小值");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
    public static String convert2(String s,int numRows){
        String[] strings = new String[numRows];
        //先给每个strings初始化为""
        Arrays.fill(strings,"");
        int line=0;    //表示第第几行

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);    //取出当前字符
            if(line==numRows){
                int index=i;
                //给num[length-2]到num[1],之间赋字符
                for(int j=numRows-2;j>=1;j--){
                    if(index>=s.length()){
                        break;
                    }
                    strings[j]+=s.charAt(index);
                    index++;
                }
                //最后再把index赋值给i
                i=index-1;
                //最后再把line清零
                line=0;
            }else{
                strings[line]+=ch;
                line++;
            }
        }
        //定义一个str，把strings里面的拼接起来即可
        StringBuilder str= new StringBuilder();
        for (String string : strings) {
            str.append(string);
        }
        return str.toString();
    }

    /*
    定义一个字符串数组，如果4行，长度就定位4，arr【0】就存第一行字符串
    定义一个line=0，每当line到numRows时候，下面，给num[length-2]到num[1],之间赋字符,然后清空line，循环，直到s遍历完
    最后再把字符串数组拼接起来返回
    */
    public static String convert(String s, int numRows) {
        String[] strings = new String[numRows];
        //先给每个strings初始化为""
        Arrays.fill(strings,"");
        int line=0;    //表示第第几行
        int index=0;
        while(index<s.length()){
            char ch=s.charAt(index);
            if(line==numRows){
                int copyIndex=index;
                for(int i=numRows-2;i>=1;i--){
                    if(copyIndex>=s.length()){
                        break;
                    }
                    strings[i]+=s.charAt(copyIndex);
                    copyIndex++;
                }
                index=copyIndex;
                line=0; //清0
            }else{
                strings[line%numRows]+=ch;
                index++;
                line++;
            }
        }

        //定义一个str，把strings里面的拼接起来即可
        StringBuilder str= new StringBuilder();
        for (String string : strings) {
            str.append(string);
        }
        return str.toString();
    }
}
