package practice.two;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("iq");
        arr.add("un");
        arr.add("ueg");
        System.out.println(maxLength(arr));
    }
    public static int maxLength(List<String> arr) {
        res = 0;
        dfs(arr,0,"");
        return res;
    }
    static int res;
    public static void dfs(List<String> arr,int index,String cur){
        if(index==arr.size()){
            return;
        }

        for(int i=index;i<arr.size();i++){
            if(isOk(cur,arr.get(i))){
                res = Math.max(res,cur.length()+arr.get(i).length());
                dfs(arr,i+1,cur+arr.get(i));
            }
        }
    }
    public static boolean isOk(String str1,String str2){
        Set<Character> set = new HashSet<>();
        for(char ch:str1.toCharArray()){
            if(!set.add(ch)){
                return false;
            }
        }
        for(char ch:str2.toCharArray()){
            if(!set.add(ch)){
                return false;
            }
        }
        return true;
    }
}