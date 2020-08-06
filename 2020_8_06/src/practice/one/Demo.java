package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/8/6 15:39
 * Introduce:  字符串的方法
 */
public class Demo {
    public static void main(String[] args) {
        String str = "abcdefg";
//        String ret = reverse(str,0,str.length()-1);
//        System.out.println(ret);
        System.out.println(stringRevolve2(str,3));
    }
    public static String stringRevolve2(String str,int index){
        if(index<0||str==null||index>=str.length()){
            return null;
        }
        str = reverse(str,0,index-1);
        str = reverse(str,index,str.length()-1);
        str = reverse(str,0,str.length()-1);
        return str;
    }

    public static String stringRevolve(String str,int index){
        if(index<0||index>=str.length()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(str);
        char[] strArr = sb.toString().toCharArray();
        sb=new StringBuilder();
        for(int i=index;i<index+str.length();i++){
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    public static String reverse(String str,int begin,int end){
        char[] strArr = str.toCharArray();
        for(int i=begin,j=end;i<j;i++,j--){
            strArr[i]^=strArr[j];
            strArr[j]^=strArr[i];
            strArr[i]^=strArr[j];
        }

        return String.valueOf(strArr);
    }
}
