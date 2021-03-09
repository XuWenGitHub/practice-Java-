package practice.one;

class Solution {
    public static void main(String[] args) {
        char ch = 1+'a';
        System.out.println(ch);
    }

    //‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E',后面必须跟数字或者正负号
    //正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
    public boolean isNumber(String s) {
        if(s==null||s.length()==0||s==""){
            return false;
        }
        boolean isNum = false;
        boolean isE = false;
        boolean isDian = false;
        char[] chars = s.trim().toCharArray();
        for(int i=0;i<chars.length;i++){
            char ch = chars[i];
            if(ch=='+'||ch=='-'){
                //正负号必须是第一个or前面是e（E）后面可以跟正负号，正负号的后面一定要跟数字
                if(i!=0&&(i-1<0||(i-1>=0&&chars[i-1]!='e'&&chars[i-1]!='E'))){
                    return false;
                }
                isNum = false;  //正负号后面一定要跟着数字
            }else if(ch=='.'){
                //点只能出现一次，并且只能在e的前面出现
                if(isDian||isE){
                    return false;
                }
                isDian = true;
            }else if(ch=='E'||ch=='e'){
                //E和e前面必须要有数字，并且只能出现一次。
                //E和e的后面必须也要有数字。
                if(!isNum||isE){
                    return false;
                }
                isNum = false;
                isE = true;
            }else if(ch>='0'&&ch<='9'){
                isNum = true;
            }else if(ch==' '){
                //字符串已经去除前面和后面的空格了，中间不能出现空格
                return false;
            }else{
                //不能有其他字符
                return false;
            }
        }
        return isNum;   //最后必须要存在数字
    }
}
