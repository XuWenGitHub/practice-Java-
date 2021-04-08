package practice.one;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        tmp = new LinkedList<>();
        dfs(S.toCharArray(),0);
        if(tmp.size()<3){
            return new LinkedList<>();
        }
        return tmp;
    }
    LinkedList<Integer> tmp;
    public boolean dfs(char[] str,int index){
        if(tmp.size()>=3){  //如果当前集合中元素超过3个，就判断最后三个是否满足斐波那契数
            if((tmp.get(tmp.size()-3)+tmp.get(tmp.size()-2))!=tmp.peekLast()){
                return false;
            }
        }
        if(index==str.length){  //如果上面满足，且已经用完str的所有字符
            //如果tmp中元素个数大于2，那就说明满足了斐波那契序列
            return tmp.size() > 2;
        }

        long temp=0;    //记录上一次当前数字用的多少
        //第一个数可以是：1  12  123  1234
        for(int i=index;i<str.length;i++){
            int cur = str[i]-'0';   //获取当前元素的值
            if(i!=index&&temp==0){  //如果不是当前数字第一个，并且temp为0，说明前一个数是0，我们便不能把0和后面的数字融成一个数字
                return false;
            }
            temp*=10;
            temp+=cur;  //更新当前数字
            if(temp>Integer.MAX_VALUE){ //判断当前数字是否已经超过int最大值
                return false;
            }
            tmp.addLast((int)temp); //添加到队列尾部
            boolean f = dfs(str,i+1);   //去添加下一个斐波那契数
            if(f){  //如果已经找到了，就不要回溯的时候去删除双向链表最后一个元素了
                return true;
            }
            tmp.removeLast();   //回溯！！！！！
        }
        return false;   //如果当前斐波那契数没找到，返回false即可
    }
}