class Solution {
    static char[] chars;
    static int count;
    static String res;

    public static void main(String[] args) {
        System.out.println(getHappyString(1,3));
    }
    public static String getHappyString(int n, int k) {
        chars = new char[n];
        count=0;
        res = "";
        dfs(0,k);
        return res;
    }

    public static void dfs(int index,int k){
        if(count==k){
            StringBuilder sb = new StringBuilder();
            for(char ch:chars){
                sb.append(ch);
            }
            res = sb.toString();
            return;
        }
        if(index==chars.length){
            count++;
            return;
        }
        for(int i=0;i<3;i++){
            setChars(i,index);
            if(happyChars(index)){
                dfs(index+1,k);
            }else{
                continue;
            }
        }
    }
    public static void setChars(int i,int index){
        if(i==0){
            chars[index] = 'a';
        }else if(i==1){
            chars[index] = 'b';
        }else{
            chars[index] = 'c';
        }
    }
    public static boolean happyChars(int index){
        if(index==0){
            return true;
        }
        return chars[index]!=chars[index-1];
    }
}