import java.util.ArrayList;
import java.util.List;

class Solution {
    static int[] king;
    static int max;
    static List<List<String>> res;
    public static List<List<String>> solveNQueens(int n) {
        king = new int[n];
        max = n;
        res = new ArrayList<List<String>>();
        check(0);
        return res;
    }
    public static void check(int n){   //n代表放第几个皇后
        if(n==max){ //说明皇后放好了
            List<String> inner = new ArrayList<>();
            for(int i=0;i<king.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<king.length;j++){
                    if(king[i]==j){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                inner.add(sb.toString());
            }
            res.add(inner);
            return;
        }
        //依次放入皇后
        for(int i=0;i<max;i++){
            king[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }
    public static boolean judge(int n){    //表示第n个皇后，判断和前面的是否冲突
        for(int i=0;i<n;i++){
            if(king[i]==king[n]||Math.abs(n-i)==Math.abs(king[n]-king[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for(List<String> e:solveNQueens(4)){
            System.out.println(e);
        }
    }
}