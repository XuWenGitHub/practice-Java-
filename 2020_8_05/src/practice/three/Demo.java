package practice.three;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/5 22:17
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        String s = "asd asd";
        System.out.println(s.replace(' ', '1'));
        System.out.println(myReplace(s, ' ', '1'));
        System.out.println(s.indexOf(""));
        System.out.println(myIndexOf(s,"ad"));
        System.out.println(myContains(s,"ad"));
        System.out.println(myCompareTo("abca","abcb"));

        System.out.println(Arrays.toString(mySplit(s," ")));
    }
    //实现方法 compareTo, 能够实现按照字典序比较字符串大小
    public static int myCompareTo(String str1,String str2){
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int len = Math.min(str1Arr.length, str2Arr.length);
        int i;
        for(i=0;i<len;i++){
            if(str1Arr[i]>str2Arr[i]){
                return str1Arr[i]-str2Arr[i];
            }else if(str1Arr[i]<str2Arr[i]){
                return str1Arr[i]-str2Arr[i];
            }
        }
        if(i==len&&str1Arr.length==str2Arr.length){
            return 0;
        }
        return str1Arr.length>str2Arr.length?str1Arr[i]:str2Arr[i];
    }

    //实现方法 contains, 能够判定字符串中是否包含子串
    public static boolean myContains(String str,String strSon){
        if(strSon.equals("")){
            return true;
        }
        char[] strArr = str.toCharArray();
        char[] strSonArr = strSon.toCharArray();
        for(int i=0;i<strArr.length;i++){
            if(strSonArr[0]==strArr[i]){
                int j;
                for(j=0;j<strSonArr.length;j++){
                    if(i+j>=strArr.length||strSonArr[j]!=strArr[i+j]){
                        break;
                    }
                }
                if(j==strSonArr.length){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *实现方法 indexOf, 能够找出字符串子串存在的位置,找不到返回-1
     * @param str   父串
     * @param strSon    子串
     * @return  第一个下标
     */
    public static int myIndexOf(String str,String strSon){
        if(strSon.equals("")){
            return 0;
        }
        char[] strArr = str.toCharArray();
        char[] strSonArr = strSon.toCharArray();
        for(int i=0;i<strArr.length;i++){
            if(strSonArr[0]==strArr[i]){
                int j;
                for(j=0;j<strSonArr.length;j++){
                    if(i+j>=strArr.length||strSonArr[j]!=strArr[i+j]){
                        break;
                    }
                }
                if(j==strSonArr.length){
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * 实现方法 replace, 能够替换字符串中的某个部分
     * @param str   传过来的字符串
     * @param oldChar   老的字符
     * @param newChar   新的字符
     * @return  新的字符串
     */
    public static String myReplace(String str,char oldChar,char newChar){
        char[] chars= str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]==oldChar){
                chars[i]=newChar;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:chars){
            sb.append(c);
        }
        return sb.toString();
    }

    /*
    实现方法 split, 能够指定分割符将字符串拆分成字符串数组(不必支持正则表达式)
     */
    public static String[] mySplit(String str,String regex){
        ArrayList<String> arrayList = new ArrayList<>();
        char[] strArr = str.toCharArray();
        char[] regexArr = regex.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strArr.length;i++){
            if(strArr[i]==regexArr[0]){
                int j;
                for(j=0;j<regexArr.length;j++){
                    if(i+j>=strArr.length||strArr[i+j]!=regexArr[j]){
                        break;
                    }
                }
                if(j==regexArr.length){
                    arrayList.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            sb.append(strArr[i]);
        }
        String[] strings = new String[arrayList.size()];
        int index=0;
        for(String s:arrayList){
            strings[index]=s;
            index++;
        }
        return strings;
    }
}
