public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numDistinct("babgbag", "bag", 0, 0);
        System.out.println(i);
    }
    public int numDistinct(String s, String t,int sIndex,int tIndex) {
        if(tIndex==t.length()){
            return 1;
        }
        if(sIndex==s.length()){
            return 0;
        }
        if(s.charAt(sIndex)==t.charAt(tIndex)){
            return numDistinct(s,t,sIndex+1,tIndex+1)+numDistinct(s,t,sIndex+1,tIndex);
        }else{
            return numDistinct(s,t,sIndex+1,tIndex);
        }
    }
}
