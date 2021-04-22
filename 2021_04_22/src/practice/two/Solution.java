package practice.two;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{
                {0,0}
        }));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else if(j-1>=0&&obstacleGrid[i][j-1]==0&&i-1>=0&&obstacleGrid[i-1][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else if(j-1>=0&&obstacleGrid[i][j-1]==0){
                    dp[i][j]=dp[i][j-1];
                }else if(i-1>=0&&obstacleGrid[i-1][j]==0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    if(i==0&&j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=0;
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
