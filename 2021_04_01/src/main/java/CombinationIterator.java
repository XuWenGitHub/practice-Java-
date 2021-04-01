import java.util.Deque;
import java.util.LinkedList;

public class CombinationIterator {

    Deque<String> list;
    char[] str;
    public CombinationIterator(String characters, int combinationLength) {
        list = new LinkedList<>();
        str = new char[combinationLength];
        dfs(characters.toCharArray(),0,0);
    }
    //去把字母所有组合全部添加进list
    //abcde  求2个
    //ab ac ad ae bc bd be cd ce de
    public void dfs(char[] chars,int strIndex,int charsIndex){
        if(strIndex==str.length){
            //代表凑够了
            StringBuilder sb = new StringBuilder();
            for (char c : str) {
                sb.append(c);
            }
            list.add(sb.toString());
            return;
        }
        if(charsIndex==chars.length){
            //代表越界了
            return;
        }
        //去dfs填充每个str的位置
        for(int i=charsIndex;i<chars.length;i++){
            str[strIndex] = chars[i];
            dfs(chars,strIndex+1,i+1);
        }
    }
    public String next() {
        return list.removeFirst();
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}