package practice.one;

class Solution {
    public static void main(String[] args) {
        System.out.println(sumNums(4));
    }
    public static int sumNums(int n) {
        boolean flag = n>0&&(n+=sumNums(n-1))>0;
        return n;
    }
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    //[i][j],k代表words中第k个
    public boolean dfs(char[][] board,char[] words,int i,int j,int k){
        if(i<0||i>board.length-1||j<0||j>board[i].length-1||board[i][j]!=words[k]){
            return false;
        }
        if(k==words.length-1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '/';
        boolean flag = dfs(board,words,i+1,j,k+1)||dfs(board,words,i-1,j,k+1)||dfs(board,words,i,j+1,k+1)||dfs(board,words,i,j-1,k+1);
        board[i][j] = temp;
        return flag;
    }
}
