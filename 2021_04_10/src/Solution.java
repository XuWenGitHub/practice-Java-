import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return new ArrayList<String>();
        }
        map = new HashMap<>();
        init(map);
        res = new ArrayList<>();
        temp = new LinkedList<>();
        dfs(digits.toCharArray(),0);
        return res;
    }
    Map<Integer,List<Character>> map;
    List<String> res;
    LinkedList<Character> temp;
    public void dfs(char[] digits,int index){
        if(index==digits.length){
            if(temp.size()==digits.length) {
                StringBuilder sb = new StringBuilder();
                for (Character ch : temp) {
                    sb.append(ch);
                }
                res.add(sb.toString());
            }
            return;
        }

        for(int i=index;i<digits.length;i++){
            for(int j=0;j<map.get(digits[i]-'0').size();j++){
                temp.addLast(map.get(digits[i]-'0').get(j));
                dfs(digits,i+1);
                temp.removeLast();
            }
        }
    }
    public void init(Map<Integer, List<Character>> map){
        char ch = 'a';
        for(int i=2;i<10;i++){
            List<Character> value = new ArrayList<>();
            for(int j=0;j<3;j++){
                value.add(ch);
                ch+=1;
            }
            if(i==7||i==9){
                value.add(ch);
                ch+=1;
            }
            map.put(i,value);
        }
    }
}