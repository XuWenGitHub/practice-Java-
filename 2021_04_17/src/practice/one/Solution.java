package practice.one;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("bbbba",".*a*a"));
    }
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(),0,p.toCharArray(),0);
    }
    public boolean isMatch(char[] s,int sIndex,char[] p,int pIndex){
        if(sIndex==s.length&&pIndex==p.length){
            return true;
        }
        if(sIndex==s.length||pIndex==p.length){
            if(pIndex<p.length){
                if(p[pIndex]=='*'){
                    return isMatch(s,sIndex,p,pIndex+1);
                }
            }
            if(pIndex+1<p.length&&p[pIndex+1]=='*'){
                return isMatch(s,sIndex,p,pIndex+2);
            }
            return false;
        }

        if(p[pIndex]==s[sIndex]){
            boolean f = false;
            if(pIndex+1<p.length&&p[pIndex+1]=='*'){
                f = isMatch(s,sIndex,p,pIndex+2);
            }
            return f||isMatch(s,sIndex+1,p,pIndex+1);
        }else{
            if(p[pIndex]=='.'){
                return isMatch(s,sIndex+1,p,pIndex+1);
            }
            if(p[pIndex]=='*'){
                if(p[pIndex-1]==s[sIndex]||p[pIndex-1]=='.'){
                    //||isMatch(s,sIndex+1,p,pIndex+1)
                    return isMatch(s,sIndex,p,pIndex+1)||isMatch(s,sIndex+1,p,pIndex);
                }else{

                    return isMatch(s,sIndex,p,pIndex+1);    //匹配0个前面那个元素
                }
            }else{
                if(pIndex+1<p.length&&p[pIndex+1]=='*'){
                    return isMatch(s,sIndex,p,pIndex+2);
                }
                return false;
            }
        }
    }
}
