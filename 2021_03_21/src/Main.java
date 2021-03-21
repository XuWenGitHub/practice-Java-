import java.util.Scanner;

public class Main {
    /**
     *   1 2 3 4
     * 1 0 1 0 1
     * 2 1 0 1 0
     * 3 0 1 0 1
     * 4 1 0 1 0
     *
     *
     *    1 2 3 4
     *  1 0 1 1 0
     *  2 1 0 1 0
     *  3 1 0 0 1
     *  4 0 0 0 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int grep = sc.nextInt();    //几组测试用例
        for(int i=0;i<grep;i++){
            int n = sc.nextInt();   //救援点和居民数量
            //1救援点，2-n表示(n-1)个居民点
            int m = sc.nextInt();   //表示边的数量
            int[][] tu = new int[n+1][n+1]; //表示连通图
            for(int j=0;j<m;j++){
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                //num1和num2之间可以走通
                tu[num1][num2] = 1;
                tu[num2][num1] = 1;
            }
            method(tu,n);
        }
    }
    public static void method(int[][] tu,int n){
        for(int i=2;i<tu.length;i++){   //从第二个居民开始走
            //需要两条可以去1的路
            int dfs = dfs(tu, i,n);
            if(dfs<2){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
    //目前我在index位置，要往1走
    public static int dfs(int[][] tu,int index,int n){
        if(index==1){
            return 1;
        }
        int res = 0;
        for(int i=1;i<=n;i++){
            if(tu[index][i]==1){
                 res+= dfs(tu, i, n);
            }
        }
        return res;
    }
}
