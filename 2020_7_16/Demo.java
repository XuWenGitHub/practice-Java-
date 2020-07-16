import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        int a=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要转化为二进制的数字：");
        a=sc.nextInt();
        System.out.println(a+"转化为二进制为");
        System.out.println(changeTwo(a));
        System.out.println(a+"转化为十六进制为");
        System.out.println(changeSixtten(a));
        System.out.printf("%c %c",65,48);
//        String s = "we are happy";
//        StringBuffer ss = new StringBuffer(s);
//        System.out.println(replaceSpace(ss));
//        int a=10;
//        int b=20;
//        a^=b;
//        b^=a;
//        a^=b;
//        System.out.println("a:"+a+" b:"+b);
//
//        a=sc.nextInt();
    }
    public static String changeSixtten(int a){
        Stack<Character> stack = new Stack<>(); //为了逆序
        String str="";
        char c=' ';
        if(a==0){
            str="0";
        }
        int m;
        while(a!=0){
            m=a%16;
            if((m >= 10) && (m <= 15)){
                //说明是字母
                c=(char)('A'+(m-10));
            }else if(m>=0&&m<=9){
                //说明是数字
                c=(char)('0'+m);
            }
            stack.push(c);
            a/=16;
        }
        for(int i=stack.size();i>0;i--){
            str+=stack.pop();
        }
        return str;
    }
    public static String changeTwo(int a){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while(a!=0){
            stack.push(a&1);
            a>>=1;
        }
        for(int i=stack.size();i>0;i--){
            int value = stack.pop();
            sb.append(value);
        }

        return sb.toString();
    }
    public static String replaceSpace(StringBuffer str) {
        String regex=" ";
        //用Sring类的split方法
        String[] sp = str.toString().split(regex);    //转成字符串，然后切割，最后再拼接
        for(int i=0;i<sp.length-1;i++){
            sp[i]+="%20";
        }
        String result="";
        for(int i=0;i<sp.length;i++){
            result+=sp[i];
        }
        return result;
    }
}
