class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(),0,p.toCharArray(),0);
    }
    public boolean isMatch(char[] s,int sIndex,char[] p,int pIndex){
        if(sIndex==s.length&&pIndex==p.length){
            return true;
        }
        if(sIndex==s.length||pIndex==p.length){
            return false;
        }
        if(p[pIndex]==s[sIndex]){
            return isMatch(s,sIndex++,p,pIndex++);
        }else{
            if(p[pIndex]=='.'){
                return isMatch(s,sIndex++,p,pIndex++);
            }
            if(p[pIndex]=='*'){
                if(p[pIndex-1]==s[sIndex]){
                    return isMatch(s,sIndex++,p,pIndex++)||isMatch(s,sIndex++,p,pIndex);
                }else{
                    return isMatch(s,sIndex,p,pIndex++);    //匹配0个前面那个元素
                }
            }else{
                return false;
            }
        }
    }
}