package practice;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(spiralOrder(arr)));
    }
    public static int[] spiralOrder(int[][] matrix) {
        flag = new boolean[matrix.length][matrix[0].length];
        res = new int[(matrix.length*matrix[0].length)];
        index = 0;
        flag[0][0] = true;
        res[index++] = matrix[0][0];
        dfs(matrix,0,0);
        return res;
    }
    static boolean[][] flag;
     static int[] res;
    static int index;
    public static void dfs(int[][] matrix,int row,int lie){
        // if(row<0||row>=matrix.length||lie<0||lie>=matrix[0].lie||flag[row][lie]){
        //     return;
        // }
        //是否能够往右走
        if(lie+1<matrix[row].length&&!flag[row][lie+1]){
            //能往右走，一直走，走到不能走位置
            while(lie+1<matrix[row].length&&!flag[row][lie+1]){
                flag[row][lie+1] = true;
                res[index++] = matrix[row][lie+1];
                lie++;
            }
            dfs(matrix,row,lie);
        }else if(row+1<matrix.length&&!flag[row+1][lie]){   //是否能够往下走
            //能往下走，一直走，走到不能走的位置
            while(row+1<matrix.length&&!flag[row+1][lie]){
                flag[row+1][lie] = true;
                res[index++] = matrix[row+1][lie];
                row++;
            }
            dfs(matrix,row,lie);
        }else if(lie-1>=0&&!flag[row][lie-1]){  //是否能往左走
            //能往左走，一直走，走到不能走的位置
            while(lie-1>=0&&!flag[row][lie-1]){
                flag[row][lie-1] = true;
                res[index++] = matrix[row][lie-1];
                lie--;
            }
            dfs(matrix,row,lie);
        }else if(row-1>=0&&!flag[row-1][lie]){  //是否能往上走
            //能往上走，一直走，走到不嫩刚走的位置
            while(row-1>=0&&!flag[row-1][lie]){
                flag[row-1][lie] = true;
                res[index++] = matrix[row-1][lie];
                row--;
            }
            dfs(matrix,row,lie);
        }
    }
}
