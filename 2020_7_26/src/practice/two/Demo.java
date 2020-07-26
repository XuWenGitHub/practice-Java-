package practice.two;

public class Demo {
    public static void main(String[] args) {
        System.out.println(myAtoi("-9223372036854775808"));
        //System.out.println();
    }
    /*
    请你来实现一个 atoi 函数，使其能将字符串转换成整数。
首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0 。
提示：
本题中的空白字符只包括空格字符 ' ' 。
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
示例 1:
输入: "42"
输出: 42
示例 2:
输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:
输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:
输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:
输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
     */
    public static int myAtoi(String str) {
        char[] strArr = str.toCharArray();
        long result=0;
        //int j=0;    //
        boolean flag=true;  //表示正负数，true表示正数，false表示负数
        boolean meetNum=false;  //表示是否遇到了数字，遇到数字后，再遇到正负号，就break
        boolean meetZF=false;
        //先跳过' '
        int l=0;
        while(l<strArr.length&&strArr[l]==' '){
            l++;
        }

        for(int i=l;i<strArr.length;i++){
            //判断下一个字符是数字还是正负号还是什么都不是
            if(strArr[i]=='+'){
                if(meetZF){
                    break;
                }
                if(meetNum){
                    break;
                }
                meetZF=true;    //表示遇到正负号了，下次再遇到就break
            }else if(strArr[i]=='-'){
                if(meetZF){
                    break;
                }
                if(meetNum){
                    break;
                }
                flag=false; //表示负数
                meetZF=true;    //表示遇到正负号了，下次再遇到就break
            }else if(strArr[i]>='0'&&strArr[i]<='9'){
                meetNum=true;   //表示遇到了数字了
                if((result*10+(strArr[i]-'0'))>Integer.MAX_VALUE){
                    //如果进来表示再加一下，就超过int范围了
                    result*=10;
                    result+=(strArr[i]-'0');
                    break;
                }
                result*=10;
                result+=(strArr[i]-'0');
            }else if(strArr[i]=='.'){
                //如果遇到.直接break，忽略不计后面的
                break;
            }else{
                if(result==0){
                    //说明一开始跳过空格了，就直接遇到了其他不认识的字符，就直接return0，表示转不了
                    return 0;
                }
                break;
            }
        }
        //给result加正负号
        if(flag){
        }else{
            result=-result;
        }
        //判断是否超过int上下线
        if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        //return 0;
        return (int)result;
    }
}
