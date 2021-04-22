package practice.three;

class Solution {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
        Solution solution = new Solution();
        System.out.println(solution.maximalRectangle(arr));
    }
    /*
    dp[i][j]：先求出i行中第j列，包含j列最长的width
    例如示例1中第二列：
    1 0 1 2 3
    如果j-1>=0&&dp[i][j-1]==1&&matrix[i][j]==1：dp[i][j]=dp[i][j-1]+1
    反之：dp[i][j]=matrix[i][j]

    现在dp[i][j]：就是当前第i行第j列，包含j中最长的width长度
    然后定义变量width=dp[i][j]; //宽度
    height=1;   //高度
    area = width*height
    然后j--：width=min(width,dp[i][j-1])  height+=1  area=max(area,width*height)
    */
    public int maximalRectangle(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;    //代表最大矩阵面积
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                //先设置当前行，当前列中，最长的width
                if(j-1>=0&&dp[i][j-1]>=1&&matrix[i][j]=='1'){
                    dp[i][j] = dp[i][j-1]+1;
                }else{
                    dp[i][j] = matrix[i][j]-'0';
                }

                //算以当前位置的方块为矩阵右下角的最大面积
                if(dp[i][j]>0){
                    int width = dp[i][j];   //矩阵的长
                    int height = 1; //矩阵的高度
                    res = Math.max(res,width*height);   //矩阵的面积
                    int temp = i;
                    while(--temp>=0){
                        width = Math.min(dp[temp][j],width);
                        height++;
                        res = Math.max(res,width*height);
                    }
                }
            }
        }
        return res;
    }
}
