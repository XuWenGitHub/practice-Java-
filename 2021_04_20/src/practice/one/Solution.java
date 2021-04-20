package practice.one;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab","b*b*ab**ba*b**b***bba"));
        //"bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab"
        //"b*b*ab**ba*b**b***bba"
    }
    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(),0,p.toCharArray(),0);
    }
    public boolean dfs(char[] s,int sIndex,char[] p,int pIndex){
        if(sIndex==s.length&&pIndex==p.length){
            return true;
        }
        if(sIndex==s.length||pIndex==p.length){
            if(pIndex<p.length&&p[pIndex]=='*'){
                return dfs(s,sIndex,p,pIndex+1);
            }
            return false;
        }

        if(p[pIndex]==s[sIndex]){
            return dfs(s,sIndex+1,p,pIndex+1);
        }else{
            if(p[pIndex]=='?'){
                return dfs(s,sIndex+1,p,pIndex+1);
            }else if(p[pIndex]=='*'){
                return dfs(s,sIndex,p,pIndex+1)||dfs(s,sIndex+1,p,pIndex);
            }else{
                return false;
            }
        }
    }
}
