import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2},
                {3},
                {3},
                {}
        };
        for(List<Integer> e:allPathsSourceTarget(arr)){
            System.out.println(e);
        }
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        inner = new LinkedList<>();
        res = new ArrayList<>();
        dfs(graph,0);
        return res;
    }
    //num代表当前遍历到哪个节点了
    static List<List<Integer>> res;
    static LinkedList<Integer> inner;
    public static void dfs(int[][] graph,int num){
        inner.add(num);
        if(num==graph.length-1){
            res.add(new LinkedList<>(inner));
            return;
        }
        for(int i=0;i<graph[num].length;i++){
            dfs(graph,graph[num][i]);
            inner.removeLast();
        }
    }
}