import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    //单词拆分2
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        inner = new LinkedList<>();
        size = 0;
        dfs(s,0,1,wordDict);
        return res;
    }
    List<String> res;   //最后返回的结果
    Deque<String> inner;    //存储一种结果的每一个单词
    int size;   //inner中字符串的总长度

    //截取s的[left,right)字符串
    public void dfs(String s,int left,int right,List<String> wordDict){
        if(right>s.length()){   //如果right>s,length()代表s用完了
            if(size==s.length()){   //如果size等于s.length()代表目前一种组合ok了
                StringBuilder sb = new StringBuilder();
                boolean f = true;
                for(String ss:inner){
                    if(f){
                        sb.append(ss);
                        f = false;
                    }else{
                        sb.append(" ").append(ss);
                    }
                }
                res.add(sb.toString());
            }
            return;
        }

        String str = s.substring(left,right);   //截取[left,right)字符串
        if(wordDict.contains(str)){ //判断是否在词典中
            inner.addLast(str); //在词典中，添加到inner尾部
            size+=str.length(); //size保存inner所有字符串的总长度
            dfs(s,right,right+1,wordDict);  //然后当前[left,right)已经用了，然后去判断[right,right+1)的字符串
            inner.removeLast();     //!!!!!!!!!!回溯，需要删除inner中最后一个
            size-=str.length(); //!!!!!!!!!!回溯，去删除inner所有字符串的总长度
            dfs(s,left,right+1,wordDict);   //就算[left,right)可以组成一个单词，但是[left,right+1)也可能是个单词，新的组合
        }else{
            dfs(s,left,right+1,wordDict);   //目前没有再词典中，向下dfs
        }
    }


}