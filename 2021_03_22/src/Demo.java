import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* 1 0 1 1 1
* 1 0 1 0 1
* 1 1 1 0 1
*
*
*       0 2
*       0 1
*
* dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1)
* 如果[i,j]坐标的上面和左边都为0，返回-1
* 如果任何一个为0，走另一条路
* */
public class Demo {
    /*
* 1 1 1 1 1
* 1 0 1 0 1
* 1 1 1 0 1
*
*
*
*/
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,1,1,0,1}
        };
        flag = true;
        dp = new int[arr.length][arr[0].length];
        dfs(arr,0,0);
        for(int[] element:dp){
            System.out.println(Arrays.toString(element));
        }
    }
    static int[][] dp;
    static boolean flag;
    public static void dfs(int[][] arr,int i,int j){
        //表示越界
        if(i<0||i>=arr.length||j<0||j>=arr[0].length){
            return;
        }
        if(i==arr.length-1&&j==arr[0].length-1){
            dp[i][j] = 1;
            return;
        }
        dfs(arr,i+1,j);
        dfs(arr,i,j+1);
        if(flag){
            if(i==arr.length-1&&j==arr[0].length-1){
                flag = false;
            }else{
                return;
            }
        }
        if(arr[i][j]==1){
            if(i+1>=arr.length&&j+1>=arr[i].length){    //表示当前的下面和右边，不存在
                //不可能出现这种情况
            }else if(i+1<arr.length&&j+1>=arr[i].length){   //下面存在，右边不存在
                if(arr[i+1][j]==0){
                    dp[i][j] = Integer.MAX_VALUE;
                }else{
                    dp[i][j] = dp[i+1][j]+1;
                }
            }else if(i+1>=arr.length&&j+1<arr[i].length){   //下面不存在，右边存在
                if(arr[i][j+1]==0){
                    dp[i][j] = Integer.MAX_VALUE;
                }else{
                    dp[i][j] = dp[i][j+1]+1;
                }
            }else{  //下面和右边都存在
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+1;
            }
        }else {
            dp[i][j] = Integer.MAX_VALUE;
        }
    }
//    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
//        String s = "abdasdasdasda";
//        System.out.println(s.hashCode());
//        int hash = s.hashCode();
//        System.out.println(hash^(hash>>>16));
//        hash = hash^(hash>>>16);
//        System.out.println(hash&(16-1));
//    }
}
