package practice.one;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths2(7,3));
    }
    /*
    dp[i][j]：代表机器人到网格[i,j]位置有多少条路径
    因为机器人只能向下or向右移动一步
    所以机器人到网格[i,j]只可能从[i-1][j]位置 or [i][j-1]位置过来
    所以dp[i][j] = dp[i-1][j]+dp[i][j-1]
    */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i-1>=0&&j-1>=0){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }else if(i-1>=0){
                    dp[i][j]=dp[i-1][j];
                }else if(j-1>=0){
                    dp[i][j]=dp[i][j-1];
                }else{
                    dp[i][i]=1;
                }
            }
        }
        return dp[m-1][n-1];
    }

    //dfs解决
    int res;
    public int uniquePaths2(int m,int n){
        res=0;
        dfs(m,n,0,0);
        return res;
    }
    public void dfs(int m,int n,int i,int j){
        if(i>=m||j>=n){
            return;
        }
        if(i==m-1&&j==n-1){
            res+=1;
        }
        dfs(m,n,i+1,j);
        dfs(m,n,i,j+1);
    }
}
