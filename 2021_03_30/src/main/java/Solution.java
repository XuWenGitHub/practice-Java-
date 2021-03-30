class Solution {
    /*
    （1）先计算出起始点，到终点，一共需要多少步（多少个0+1），并且记录终点坐标
    （2）去dfs，每走一步，减少一步，当0步，并且当前位置为终点左边，表示ok
    */
    public int uniquePathsIII(int[][] grid) {
        int[] end = new int[2]; //存储终点坐标
        int row = -1;   //起点的横坐标
        int lie = -1;   //起点的纵坐标
        int step = 0;   //记录从起点到终点，一共需要多少步
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){  //表示起点
                    row = i;
                    lie = j;
                    continue;
                }else if(grid[i][j]==2){    //表示终点
                    end[0] = i;
                    end[1] = j;
                }else if(grid[i][j]==-1){   //表示走不通
                    continue;
                }
                step++; //计算步数
            }
        }
        dfs(grid,row,lie,step,isVisited,end);
        return res;
    }
    int res = 0;
    public void dfs(int[][] grid,int i,int j,int step,boolean[][] isVisited,int[] end){
        //表示越界等其他情况，表示走不通了
        if(i<0||i>=grid.length||j<0||j>=grid[i].length||isVisited[i][j]||grid[i][j]==-1){
            return;
        }
        if(step==0){    //代表步数走够了
            if(i==end[0]&&j==end[1]){   //如果当前位置是终点
                res++;
            }
            return;     //不return也可以，因为当前位置其他位置都已经访问过了
        }
        isVisited[i][j] = true;
        dfs(grid,i+1,j,step-1,isVisited,end);
        dfs(grid,i-1,j,step-1,isVisited,end);
        dfs(grid,i,j+1,step-1,isVisited,end);
        dfs(grid,i,j-1,step-1,isVisited,end);
        //回溯时，如果当前位置上下左右都走过了，要设置当前位置没有被访问
        isVisited[i][j] = false;    //回溯！！！！！！当前位置要退走之前，要回溯到没有访问过
    }
}